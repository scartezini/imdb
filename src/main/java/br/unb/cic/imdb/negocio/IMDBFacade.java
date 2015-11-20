package br.unb.cic.imdb.negocio;

import java.util.List;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOFactory.DataBase;
import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.integracao.DAOTrabalhoArtistico;
import br.unb.cic.imdb.integracao.DAOUsuario;

/**
 * Classe de fachada (Facade class) que vai servir de comunicacao 
 * entre a camada de apresentacao (ui) e a camada de negocio. Caso 
 * se torne excessivamente complexa, essa classe deve ser sub-dividida.
 *  
 * @author rbonifacio
 */
public class IMDBFacade {
	
	private DAOGenero daoGenero;
	private DAOAutor daoAutor;
	private DAOUsuario daoUsuario;
	private DAOAvaliacao daoAvaliacao;
	private DAOTrabalhoArtistico daoTrabalhoArtistico;
	
	public IMDBFacade() {}
	
	//Usando o Spring Framework, o construtor declarado 
	//nas proximas linhas se torna desnecessario, uma vez 
	//que o proprio Spring injeta as implementacoes corretas das classes DAOs. 
	
//	public IMDBFacade() {
//			daoGenero = DAOFactory.instance(DataBase.SQLDB).createDAOGenero();
//			daoAutor = DAOFactory.instance(DataBase.SQLDB).createDAOAutor();
//	}
	
	public void adicionaGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) == null) {
			daoGenero.salvar(genero);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	public List<Genero> recuperarGeneros() {
		return daoGenero.recuperaTodos();
	}

	public Genero recuperarGeneroPorTitulo(String titulo) {
		return daoGenero.recuperaPorTitulo(titulo);
	}
	
	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}
	
	
	/******/
	
	public void adicionaAutor(Autor autor){
		if(recuperarAutoresPorNome(autor.getNome()) == null){
			daoAutor.salvar(autor);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public List<Autor> recuperarAutores(){
		return daoAutor.recuperarTodos();
	}
	
	public Autor recuperarAutoresPorNome(String nome){
		return daoAutor.recuperarPorNome(nome);
	}


	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}
	
	/********/
	
	public void adicionaUsuario(Usuario usuario){
		if(recuperarUsuarioPorLogin(usuario.getLogin()) == null){
			daoUsuario.salvar(usuario);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public Usuario recuperarUsuarioPorLogin(String login){
		return daoUsuario.recuperarPorLogin(login);
	}

	public void deletarUsuario(Usuario usuario){
		daoUsuario.deletar(usuario);
	}
	
	
	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	/*********/
	
	public void adicionaAvaliao(Avaliacao avaliacao){
		daoAvaliacao.salvar(avaliacao);
	}
	
	public List<Avaliacao> recuperarAvaliacaoPorUsuario(Usuario usuario){
		return daoAvaliacao.recuperarVarias(usuario);
	}
	
	public List<Avaliacao> recuperarAvaliacaoPorTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico){
		return daoAvaliacao.recuperarVarias(trabalhoArtistico);
	}
	
	public List<Avaliacao> recuperarPorAvaliacao(int avaliacao){
		return daoAvaliacao.recuperarPorNota(avaliacao);
	}

	public void setDaoAvaliacao(DAOAvaliacao daoAvaliacao) {
		this.daoAvaliacao = daoAvaliacao;
	}
	
	/********/
	
	public void adicionarTrabalhoArtistico(TrabalhoArtistico trabalhoArtistico){
		if(recuperarTrabalhoArtisticoPorTitulo(trabalhoArtistico.getTitulo()) == null){
			daoTrabalhoArtistico.salvar(trabalhoArtistico);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}
	
	public List<TrabalhoArtistico> recuperarTrabalhosArtistico(){
		return daoTrabalhoArtistico.recuperarTodos();
	}
	
	public TrabalhoArtistico recuperarTrabalhoArtisticoPorTitulo(String titulo){
		return daoTrabalhoArtistico.recuperarPorTitulo(titulo);
	}
		
	
}
