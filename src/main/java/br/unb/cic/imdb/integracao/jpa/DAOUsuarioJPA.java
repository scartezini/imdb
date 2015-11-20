package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOUsuario;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioJPA implements DAOUsuario {
	
	private EntityManager em; 
	
	
	@Override
	public void salvar(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
	}

	@Override
	public void deletar(Usuario usuario) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.createQuery("DELETE FROM Usuario WHERE id = :idParam")
				.setParameter("idParam", usuario.getId()).executeUpdate();
		
	}

	@Override
	public Usuario recuperarPorLogin(String login) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario>  results = em.createQuery("FROM Usuario WHERE login = :loginParam")
				.setParameter("loginParam", login).getResultList();
		
		return results.size() == 1 ? results.get(0):null;
	}

}
