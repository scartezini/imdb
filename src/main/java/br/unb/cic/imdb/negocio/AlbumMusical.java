package br.unb.cic.imdb.negocio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AlbumMusical")
public class AlbumMusical extends TrabalhoArtistico {




    @Column
    @OneToOne
    private TrabalhoArtistico trabalhoArtistico;

    @OneToMany(mappedBy = "album")
    private List<FaixaMusical> faixaMusical;


    public List<FaixaMusical> getFaixaMusical() {
        return faixaMusical;
    }

    public void setFaixaMusical(List<FaixaMusical> faixaMusical) {
        this.faixaMusical = faixaMusical;
    }

    public TrabalhoArtistico getTrabalhoArtistico() {
        return trabalhoArtistico;
    }

    public void setTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico) {
        this.trabalhoArtistico = trabalhoArtistico;
    }
}