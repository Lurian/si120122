package microBlog;


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
			linhaDoTempo.addPostagem(link);
		} else {
			throw new FormatodeLinkIncorretoException("Só é aceito links no formato 'http://' ou 'https://'");
		}
	}

	public String ultimaPostagem() {
		return linhaDoTempo.getUltimaPostagem();
	}

	public int getHoraUltimaPostagem() {
		// TODO Auto-generated method stub
		return -1;
	}
	

	public int getMinutoUltimaPostagem() {
		// TODO Auto-generated method stub
		return -1;
	}

	public int getDiaUltimaPostagem() {
		// TODO Auto-generated method stub
		return -1;
	}

	public int getMesUltimaPostagem() {
		// TODO Auto-generated method stub
		return -1;
	}

	public int getAnoUltimaPostagem() {
		// TODO Auto-generated method stub
		return -1;
	}

}
