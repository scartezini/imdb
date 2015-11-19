package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("AlbumMusical")
public class AlbumMusical extends TrabalhoArtistico {



    @OneToMany(mappedBy = "album")
    private List<FaixaMusical> faixaMusical;


    public List<FaixaMusical> getFaixaMusical() {
        return faixaMusical;
    }

    public void setFaixaMusical(List<FaixaMusical> faixaMusical) {
        this.faixaMusical = faixaMusical;
    }

 
}