package microBlog;

import java.util.GregorianCalendar;
import java.util.List;



public class MicroBlog {

	private LinhaDoTempo linhaDoTempo;
	
	public MicroBlog() {
		linhaDoTempo = new LinhaDoTempo();
	}
	

	public void postaLink(String link) throws FormatodeLinkIncorretoException {
		link = link.trim();
			
		if((link.startsWith("http://")
				|| link.startsWith("https://"))
				&& !link.contains(" ")){
			
			int hora = GregorianCalendar.HOUR;
			int minuto = GregorianCalendar.MINUTE;
			int dia = GregorianCalendar.DAY_OF_MONTH;
			int mes = GregorianCalendar.MONTH;
			int ano = GregorianCalendar.YEAR;
			
			linhaDoTempo.addPostagem(link, mes, ano, dia, minuto, hora);
		} else {
			throw new FormatodeLinkIncorretoException("Só é aceito links no formato 'http://' ou 'https://'");
		}
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
