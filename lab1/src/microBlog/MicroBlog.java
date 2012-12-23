package microBlog;

import java.util.GregorianCalendar;
import java.util.List;

import microBlogException.FormatoDeLinkIncorretoException;
import microBlogException.NaoHouvePostagemAindaException;
import microBlogUtil.Tempo;



public class MicroBlog {

	private LinhaDoTempo linhaDoTempo;
	
	public MicroBlog() {
		linhaDoTempo = new LinhaDoTempo();
	}
	
	public String getTempoMedioEntrePostagens() throws NaoHouvePostagemAindaException{
		return linhaDoTempo.getTempoMedioEntrePostagens();
	}
	

	public void postaLink(String link) throws FormatoDeLinkIncorretoException {
			linhaDoTempo.addPostagem(link, new Tempo(new GregorianCalendar()));
	}

	public String getLinkUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getLinkUltimaPostagem();
	}

	public int getHoraUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getHoraUltimaPostagem();
	}
	

	public int getMinutoUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getMinutoUltimaPostagem();
	}

	public int getDiaUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getDiaUltimaPostagem();
	}

	public int getMesUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getMesUltimaPostagem();
	}

	public int getAnoUltimaPostagem() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getAnoUltimaPostagem();
	}

	public String getSiteMaisPostado() throws NaoHouvePostagemAindaException {
		return linhaDoTempo.getSiteMaisPostado();
	}

	public List<Postagem> getPostagensRecentes() {
		return linhaDoTempo.getPostagensRecentes();
	}

}
