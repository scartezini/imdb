package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.negocio.IMDBFacade;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class DAOTrabalhoArtisticoJPA implements DAOTrabalhoArtistico{
	
	private EntityManager em;
	
	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalhoArtistico);
		em.getTransaction();
	}

	@Override
	public List<TrabalhoArtistico> recuperarTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico").getResultList();
	}

	@Override
	public TrabalhoArtistico recuperarPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabalhoArtisticos = em.createQuery("FROM TrabalhoArtistico WHERE titulo = :tituloParam")
					.setParameter("tituloParam", titulo)
					.getResultList();
		
		return trabalhoArtisticos.size() == 1? trabalhoArtisticos.get(0) : null;
	}

}
