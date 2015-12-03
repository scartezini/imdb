package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.Filme;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by sousa on 03/12/2015.
 */
public class DAOFilme implements br.unb.cic.imdb.integracao.DAOFilme{

    private EntityManager em;

    @Override
    public void salvar(Filme filme) {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(filme);
        em.getTransaction().commit();
    }

    @Override
    public List<Filme> recuperarTodos() {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        return em.createQuery("FROM Filme").getResultList();
    }

    @Override
    public Filme recuperarPorTitulo(String titulo) {
        em = EMFactoryHelper.instance().getFactory().createEntityManager();
        List<Filme> filmes = em.createQuery("FROM Filmes WHERE titulo = :tituloParam")
                .setParameter("tituloParam", titulo).getResultList();

        return filmes.size() == 1 ? filmes.get(0):null;
    }
}
