package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblFilme")
public class Filme implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idFilme;
	private String titulo;
	private Integer duracao;
	private Integer ano;
	
	private List<Participacao> participacoes;
	
	public Filme(){
		participacoes = new ArrayList<>();
	}

	public Filme(Integer idFilme, String titulo, Integer duracao, Integer ano) {
		super();
		this.idFilme = idFilme;
		this.titulo = titulo;
		this.duracao = duracao;
		this.ano = ano;
		participacoes = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@OneToMany(mappedBy="filme")
	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	public void addParticipacao(Participacao participacao) {
		//Associação de mão dupla
		this.participacoes.add(participacao);
		participacao.setFilme(this);
	}
	
	public void removeParticipacao(Participacao participacao) {
		this.participacoes.remove(participacao);
	}

	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", titulo=" + titulo + ", duracao=" + duracao + ", ano=" + ano + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		return true;
	}
	
	public BigDecimal cacheTotal(){
		BigDecimal soma = new BigDecimal("0.00");
		for(Participacao p:participacoes){
			soma = soma.add(p.cachePago());
		}
		return soma;
	}
}
