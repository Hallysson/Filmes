package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblParticipacao")
public class Participacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idParticipacao;
	private String personagem;
	private BigDecimal desconto;
	
	private Filme filme;
	private Artista artista;
	
	public Participacao(){
		
	}

	public Participacao(Integer idParticipacao, String personagem, BigDecimal desconto, Filme filmes, Artista artista) {
		super();
		this.idParticipacao = idParticipacao;
		this.personagem = personagem;
		this.desconto = desconto;
		this.filme = filmes;
		filme.addParticipacao(this);
		this.artista = artista;
		artista.addParticipacao(this);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getIdParticipacao() {
		return idParticipacao;
	}

	public void setIdParticipacao(Integer idParticipacao) {
		this.idParticipacao = idParticipacao;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@ManyToOne
	@JoinColumn(name = "filme")
	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	@ManyToOne
	@JoinColumn(name = "artista")
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Participacao [idParticipacao=" + idParticipacao + ", personagem=" + personagem + ", desconto="
				+ desconto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idParticipacao == null) ? 0 : idParticipacao.hashCode());
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
		Participacao other = (Participacao) obj;
		if (idParticipacao == null) {
			if (other.idParticipacao != null)
				return false;
		} else if (!idParticipacao.equals(other.idParticipacao))
			return false;
		return true;
	}
	
	public BigDecimal cachePago(){
		return artista.getCache().subtract(desconto);
	}
}
