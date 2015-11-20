package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TRABALHO_ARTISTICO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NOME_CLASSE")
public class TrabalhoArtistico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String titulo;
	
	@Column
	private int ano;
	
	
	@ManyToOne
	private Genero genero;
	
	
	@ManyToOne
	private Autor autor;
	
	
	
	public TrabalhoArtistico() {
	}

	public TrabalhoArtistico(String titulo, int ano, Genero genero, Autor autor) {
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.autor = autor;
	}
	
	
	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
