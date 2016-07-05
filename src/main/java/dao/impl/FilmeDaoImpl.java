package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.FilmeDao;
import dominio.Filme;

public class FilmeDaoImpl implements FilmeDao {

	private EntityManager em;

	public FilmeDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Filme x) {
		if (x.getIdFilme() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Filme x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Filme buscar(int id) {
		return em.find(Filme.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Filme> buscarTodos() {
		String jpql = "SELECT x FROM Filme x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
}
