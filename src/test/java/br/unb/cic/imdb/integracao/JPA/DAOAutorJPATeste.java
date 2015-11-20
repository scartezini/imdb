package br.unb.cic.imdb.integracao.JPA;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.jpa.DAOAutorJPA;
import br.unb.cic.imdb.negocio.Autor;
import junit.framework.TestCase;

public class DAOAutorJPATeste extends TestCase{
	
	public void testeSalvar(){
		Autor autor = new Autor("Teste", "descricao");
		DAOAutor daoAutor = new DAOAutorJPA();
		daoAutor.salvar(autor);
		
		Autor resultado = daoAutor.recuperarPorNome(autor.getNome());
		
		assertEquals(autor.getNome(), resultado.getNome());
	}

}
