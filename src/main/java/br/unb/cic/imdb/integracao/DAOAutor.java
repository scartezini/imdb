package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Autor;

public interface DAOAutor {
	public void salvar(Autor autor);
	public List<Autor> recuperarTodos();
	public Autor recuperarPorNome(String nome);
}
