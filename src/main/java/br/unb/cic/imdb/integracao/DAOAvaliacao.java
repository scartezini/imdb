package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.negocio.Usuario;

public interface DAOAvaliacao {
	public void salvar(Avaliacao avaliacao);
	public List<Avaliacao> recuperarVarias(TrabalhoArtistico trabalhoArtistico);
	public List<Avaliacao> recuperarVarias(Usuario usuario);
	public List<Avaliacao> recuperarPorNota(int nota);
}
