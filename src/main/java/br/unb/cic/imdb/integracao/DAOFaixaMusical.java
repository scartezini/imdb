package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;

public interface DAOFaixaMusical {
	public void salvar(FaixaMusical faixaMusical);
	public List<FaixaMusical> recuperarPorAlbum(AlbumMusical albumMusical);
	public FaixaMusical recuperarPorTitulo();
	public List<FaixaMusical> recuperarTodas();
}
