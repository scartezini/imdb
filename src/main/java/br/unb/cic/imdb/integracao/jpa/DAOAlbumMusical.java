package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by sousa on 01/12/2015.
 */
public class DAOAlbumMusical implements br.unb.cic.imdb.integracao.DAOAlbumMusical {

    private EntityManager em;

    @Override
    public void salvar(AlbumMusical albumMusical) {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(albumMusical);
        em.getTransaction().commit();
    }

    @Override
    public List<AlbumMusical> recuperarTodos() {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        return em.createQuery("FROM AlbumMusical").getResultList();
    }

    @Override
    public AlbumMusical recuperarPorTitulo(String titulo) {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        List<AlbumMusical> albumMusical = em.createQuery("FROM AlbumMusical WHERE titulo = :tituloParam")
                .setParameter("tituloParam", titulo).getResultList();

        return albumMusical.size() == 1 ? albumMusical.get(0):null;
    }
}
