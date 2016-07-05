package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FilmeDao;
import dao.Transaction;
import dominio.Filme;

public class FilmeServico {

	private FilmeDao dao;
	
	public FilmeServico() {
		dao = DaoFactory.criarFilmeDao();
	}
	
	
	public void inserirAtualizar(Filme x){
		try{
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

	public void excluir(Filme x){
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
	
	public Filme buscar(int id) {
		return dao.buscar(id);
	}
	
	public List<Filme> buscarTodos() {
		return dao.buscarTodos();
	}
}