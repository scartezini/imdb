package br.unb.cic.imdb.integracao.JPA;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.integracao.jpa.DAOTrabalhoArtisticoJPA;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import junit.framework.TestCase;

public class DAOTrabalhoArtisticoTest extends TestCase {
	
	public void testeSalvar(){
		TrabalhoArtistico trabalhoArtistico = new TrabalhoArtistico("titulo", 1997
				,new Genero("titulo", "descricao")
				,new Autor("nome", "descricao"));
		
		DAOTrabalhoArtistico daoTrabalhoArtistico = new DAOTrabalhoArtisticoJPA();
		
		daoTrabalhoArtistico.salvar(trabalhoArtistico);
		
		TrabalhoArtistico resposta = daoTrabalhoArtistico.recuperarPorTitulo(trabalhoArtistico.getTitulo());
		
		assertEquals(trabalhoArtistico.getTitulo(), resposta.getTitulo());

	}

}
