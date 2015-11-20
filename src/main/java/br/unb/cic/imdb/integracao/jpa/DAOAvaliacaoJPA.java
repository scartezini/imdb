package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOAvaliacaoJPA implements DAOAvaliacao{
	private EntityManager em; 
	
	@Override
	public void salvar(Avaliacao avaliacao) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(avaliacao);
		em.getTransaction().commit();
		
	}

	@Override
	public List<Avaliacao> recuperarVarias(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Avaliacao WHERE trabalhoArtistico = :trabalhoArtisticoParam")
								.setParameter("trabalhoArtisticoParam",trabalhoArtistico)
								.getResultList();
	}

	@Override
	public List<Avaliacao> recuperarVarias(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Avaliacao WHERE usuario = :usuarioParam")
								.setParameter("usuarioParam",usuario)
								.getResultList();
	}

	@Override
	public List<Avaliacao> recuperarPorNota(int nota) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Avaliacao WHERE avaliacao = :notaParam")
								.setParameter("notaParam",nota)
								.getResultList();
	}

}
