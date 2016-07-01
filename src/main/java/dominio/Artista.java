package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblArtista")
public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer idArtista;
	private String nome;
	private String nacionalidade;
	private BigDecimal cache;
	private Date nascimento;
	
	private List<Participacao> participacoes;
	
	public Artista(){
		participacoes = new ArrayList<>();
	}

	public Artista(Integer idArtista, String nome, String nacionalidade, BigDecimal cache, Date nascimento) {
		super();
		this.idArtista = idArtista;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.cache = cache;
		this.nascimento = nascimento;
		participacoes = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public BigDecimal getCache() {
		return cache;
	}

	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@OneToMany(mappedBy="artista")
	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao participacao) {
		//Associação de mão dupla
		this.participacoes.add(participacao);
		participacao.setArtista(this);
	}
	
	public void removeParticipacao(Participacao participacao) {
		this.participacoes.remove(participacao);
	}

	@Override
	public String toString() {
		return "Artista [idArtista=" + idArtista + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", cache="
				+ cache + ", nascimento=" + nascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArtista == null) ? 0 : idArtista.hashCode());
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
		Artista other = (Artista) obj;
		if (idArtista == null) {
			if (other.idArtista != null)
				return false;
		} else if (!idArtista.equals(other.idArtista))
			return false;
		return true;
	}
	
	
}
