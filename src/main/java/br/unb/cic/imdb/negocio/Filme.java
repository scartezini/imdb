package br.unb.cic.imdb.negocio;

import javax.persistence.*;

/**
 * Created by Scartezini on 18/11/2015.
 */

@Entity
@Table(name = "TB_Filme")
public class Filme extends TrabalhoArtistico{



    @OneToOne
    private TrabalhoArtistico trabalhoArtistico;

    @Column
    private int duracao;

    

    public TrabalhoArtistico getTrabalhoArtistico() {
        return trabalhoArtistico;
    }

    public void setTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
        this.trabalhoArtistico = trabalhoArtistico;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}