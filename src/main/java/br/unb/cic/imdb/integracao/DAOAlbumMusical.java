package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.AlbumMusical;

public interface DAOAlbumMusical {
	public void salvar(AlbumMusical albumMusical);
	public List<AlbumMusical> recuperarTodos();
	public AlbumMusical recuperarPorTitulo(String titulo);
}
