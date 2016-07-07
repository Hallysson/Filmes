package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;

	public ArtistaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		if (x.getIdArtista() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Artista buscar(int id) {
		return em.find(Artista.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodos() {
		String jpql = "SELECT x FROM Artista";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadosPorNome() {
		String sql = "SELECT x FROM Artista x ORDER BY x.nome";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Artista buscarNomeExato(String nome) {
		String sql = "SELECT x FROM Artista x WHERE x.nome = :p1";
		Query query = em.createQuery(sql);
		query.setParameter("p1", nome);
		List<Artista> aux = query.getResultList();
 		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
