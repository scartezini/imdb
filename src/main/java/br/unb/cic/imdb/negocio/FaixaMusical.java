package br.unb.cic.imdb.negocio;

import javax.persistence.*;

/**
 * Created by Scartezini on 18/11/2015.
 */

@Entity
@Table(name = "TB_FaicaMusical")
public class FaixaMusical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String titulo;

    @Column
    private int duracao;

    @ManyToOne
    private AlbumMusical album;



    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public AlbumMusical getAlbum() {
        return album;
    }

    public void setAlbum(AlbumMusical album) {
        this.album = album;
    }
}
