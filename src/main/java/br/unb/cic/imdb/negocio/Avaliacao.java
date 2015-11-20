package br.unb.cic.imdb.negocio;

import javax.persistence.*;

/**
 * Created by Scartezini on 18/11/2015.
 */
@Entity
@Table(name = "TB_Avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private int avaliacao;

    @Column
    private String comentario;
    
 
    @ManyToOne
    private TrabalhoArtistico trabalhoArtistico;
    
   
    @ManyToOne
    private Usuario usuario;

    public Avaliacao(){}
    public Avaliacao(int avaliacao, String comentario, TrabalhoArtistico trabalhoArtistico, Usuario usuario) {
		this.avaliacao = avaliacao;
		this.comentario = comentario;
		this.trabalhoArtistico = trabalhoArtistico;
		this.usuario = usuario;
	}

	public Long getId() {
        return id;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public TrabalhoArtistico getTrabalhoArtistico() {
        return trabalhoArtistico;
    }

    public void setTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
        this.trabalhoArtistico = trabalhoArtistico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}