package br.unb.cic.imdb.integracao;

import br.unb.cic.imdb.negocio.Usuario;

public interface DAOUsuario {
	public void salvar(Usuario usuario);
	public void deletar(Usuario usuario);
	public Usuario recuperarPorLogin(String login);
}
