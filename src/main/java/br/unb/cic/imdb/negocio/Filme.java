package br.unb.cic.imdb.negocio;

import javax.persistence.*;

/**
 * Created by Scartezini on 18/11/2015.
 */

@Entity
@DiscriminatorValue("Filme")
public class Filme extends TrabalhoArtistico{

    @Column
    private int duracao;


    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}