package microBlog;

import microBlogException.FormatoDeLinkIncorretoException;
import microBlogUtil.Tempo;

public class Postagem {
	private Tempo tempo;

	private String link;

	public Postagem(String link, Tempo tempo) throws FormatoDeLinkIncorretoException {
		
		if(!(link.startsWith("http://")
				|| link.startsWith("https://"))
				|| link.contains(" ")){
			throw new FormatoDeLinkIncorretoException("O link contem um formato Invalido");
		}
		this.link = link;
		this.tempo = tempo;
	}

	public Tempo getTempo() {
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}

	public int getMes() {
		return tempo.getMes();
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getAno() {
		return tempo.getAno();
	}

	public int getDia() {
		return tempo.getDia();
	}

	public int getMinuto() {
		return tempo.getMinuto();
	}

	public int getHora() {
		return tempo.getHora();
	}

	public String getLink() {
		return link;
	}

}
