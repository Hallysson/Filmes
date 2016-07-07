package servico;

public class ServicoException extends Exception{
	private static final long serialVersionUID = 1L;
		
		private Integer id;
		
		public ServicoException(Integer id, String msg){
			super(msg); //chama o construtor na superclasse
			this.id = id;
		}
		
		public Integer getId(){
			return id;
		}
}
