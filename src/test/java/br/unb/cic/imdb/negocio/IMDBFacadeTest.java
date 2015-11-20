package br.unb.cic.imdb.negocio;

import java.util.List;

import br.unb.cic.imdb.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest extends TestCase {
	
	private IMDBFacade facade = ContextoID.instance().facade();
	
	public void testeAdicionaGenero() {
		try {
		
			Genero novoGenero = new Genero("Rock", "Ok... bem melhor!"); 
		
			int quantidadeGeneros = facade.recuperarGeneros().size();
		
			facade.adicionaGenero(novoGenero);
		
                        Genero resultadoConsulta = facade.recuperarGeneroPorTitulo("Rock");
		
			assertEquals(quantidadeGeneros+1, facade.recuperarGeneros().size());
			assertNotNull(resultadoConsulta);		
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
	
	public void testeAdicionaAutor(){
		
		try {
			
			Autor novoAutor = new Autor("Jose","muito louco");
			
			facade.adicionaAutor(novoAutor);
			
			int quantidadeAutor = facade.recuperarAutores().size();
			Autor resultadoAutor = facade.recuperarAutoresPorNome("Jose");
			
			System.out.println(quantidadeAutor);
			assertEquals("Jose", resultadoAutor.getNome());
		}
		catch(Throwable t){
			t.printStackTrace();
			fail();
		}
	}
	
	public void testeAdicionarUsuario(){
		try {
			
			
			Usuario usuario = new Usuario("teste", "senha", "nome", "12/10/1997");
			facade.adicionaUsuario(usuario);
			
			Usuario respostaUsuario = facade.recuperarUsuarioPorLogin(usuario.getLogin());
			
			assertEquals(respostaUsuario.getLogin(), usuario.getLogin());
			assertEquals(respostaUsuario.getNascimento(), usuario.getNascimento());
		}
		catch(Throwable t){
			t.printStackTrace();
			fail();
		}
	}
	
//	public void testeDeletarUsuario(){
//		try{
//			IMDBFacade facade = ContextoID.instance().facade();
//			
//			Usuario usuario = new Usuario("deletar", "senha", "nome", "12/01/1997");
//			facade.adicionaUsuario(usuario);
//			
//			Usuario respostaUsuario = facade.recuperarUsuarioPorLogin(usuario.getLogin());
//			assertEquals( usuario.getLogin(),respostaUsuario.getLogin());
//			
//			facade.deletarUsuario(usuario);
//			respostaUsuario = facade.recuperarUsuarioPorLogin(usuario.getLogin());
//			
//			assertEquals(null, respostaUsuario);
//			
//		}
//		catch(Throwable t){
//			t.printStackTrace();
//			fail();
//		}
//	}
	
	public void testAdicionarAvaliacao(){
		
		
		Usuario usuario = new Usuario("login", "senha", "nome", "12/10/1997");
		TrabalhoArtistico trabalhoArtistico = new TrabalhoArtistico("titulo", 1997
												,new Genero("titulo", "descricao")
												,new Autor("nome", "descricao"));
		
		Avaliacao avaliacao = new Avaliacao(5, "comentario", trabalhoArtistico, usuario);
		
		facade.adicionaUsuario(usuario);
		facade.adicionaAvaliao(avaliacao);
		
		List<Avaliacao> resultadoPorNota = facade.recuperarPorAvaliacao(5);
		
		assertEquals(5, resultadoPorNota.get(0).getAvaliacao());
		
		
	}
	
	public void testeAdicionarTrabalhoArtistico(){
		TrabalhoArtistico trabalhoArtistico = new TrabalhoArtistico("titulo", 1997
				,new Genero("titulo", "descricao")
				,new Autor("nome", "descricao"));
		
		facade.adicionarTrabalhoArtistico(trabalhoArtistico);
		
		List<TrabalhoArtistico> trabalhoArtisticoResposta = facade.recuperarTrabalhosArtistico();
		
		assertEquals(trabalhoArtistico.getTitulo(), trabalhoArtisticoResposta.get(0).getTitulo());
		
		
	}
}
