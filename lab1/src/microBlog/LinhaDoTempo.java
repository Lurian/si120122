package microBlog;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LinhaDoTempo {

	List<Postagem> postagens;
	Map<String, Integer> mapaDosSitesPostados;
	String siteMaisPostado;
	
	public LinhaDoTempo() {
		postagens = new LinkedList<Postagem>();
		mapaDosSitesPostados = new TreeMap<String, Integer>();
	}


	public void addPostagem(String link, int mes, int ano, int dia, int minuto, int hora) {
		postagens.add(new Postagem(link, mes, ano, dia, minuto, hora));

		String site = link.split("/")[2];

		if(mapaDosSitesPostados.containsKey(site)){
			mapaDosSitesPostados.put(site, mapaDosSitesPostados.get(site) + 1);
		} else {
			mapaDosSitesPostados.put(site, 1);
		}	

		if(siteMaisPostado == null){
			siteMaisPostado = site;
		} else {
			if(mapaDosSitesPostados.get(site) >= mapaDosSitesPostados.get(siteMaisPostado)){
				siteMaisPostado = site; 
			}
		}
	}

	public String getLinkUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getLink();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getMinutoUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getMinuto();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getDiaUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getDia();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getMesUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getMes();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getAnoUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getAno();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getHoraUltimaPostagem() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			return ultimaPostagem.getHora();
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public String getSiteMaisPostado() throws NaoHouvePostagemAindaException {	
		if(postagens.size() > 0) {
			return siteMaisPostado;
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public int getTempoMedioEntrePostagens() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			Postagem primeiraPostagem = postagens.get(0);
			
			return ((ultimaPostagem.getMes()*30*24*60 + ultimaPostagem.getDia()*24*60 + ultimaPostagem.getHora()*60 + ultimaPostagem.getMinuto()) -
					(primeiraPostagem.getMes()*30*24*60 + primeiraPostagem.getDia()*24*60 + primeiraPostagem.getHora()*60 + primeiraPostagem.getMinuto()))
					/ (postagens.size() - 1);

		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}
}


