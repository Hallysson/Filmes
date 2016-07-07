package servico;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Artista;

public class ArtistaServico {

	private ArtistaDao dao;
	
	public ArtistaServico() {
		dao = DaoFactory.criarArtistaDao();
	}
		
	public void inserirAtualizar(Artista x) throws ServicoException{
		try{
			Artista aux = dao.buscarNomeExato(x.getNome());
			if (aux != null){
				throw new ServicoException(1, "Já existe um artista com este nome!");
			}
			
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		}
		catch(RuntimeException e){
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void excluir(Artista x){
		try{
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		}
		catch(RuntimeException e){
			if(Transaction.isActive()){
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Artista buscar(int id) {
		return dao.buscar(id);
	}
	
	public List<Artista> buscarTodos() {
		return dao.buscarTodos();
	}
	
	public List<Artista> buscarTodosOrdenadosPorNome(){
		return dao.buscarTodosOrdenadosPorNome();
	}
}