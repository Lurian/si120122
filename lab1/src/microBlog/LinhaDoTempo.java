package microBlog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import microBlogException.FormatoDeLinkIncorretoException;
import microBlogException.NaoHouvePostagemAindaException;
import microBlogUtil.IntervaloDeTempo;
import microBlogUtil.Tempo;

public class LinhaDoTempo {

	List<Postagem> postagens;
	Map<String, Integer> mapaDosSitesPostados;
	String siteMaisPostado;
	
	public LinhaDoTempo() {
		postagens = new LinkedList<Postagem>();
		mapaDosSitesPostados = new TreeMap<String, Integer>();
	}


	public void addPostagem(String link, Tempo tempo) throws FormatoDeLinkIncorretoException {
		postagens.add(new Postagem(link, tempo));

		String site = getDominioDoSite(link);

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
	
	public String getDominioDoSite(String link){
		return link.split("/")[2];
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


	public String getTempoMedioEntrePostagens() throws NaoHouvePostagemAindaException {
		if(postagens.size() > 0) {
			Postagem ultimaPostagem = postagens.get(postagens.size() - 1);
			Postagem primeiraPostagem = postagens.get(0);
			
			IntervaloDeTempo intervaloDeTempo = new IntervaloDeTempo(ultimaPostagem.getTempo(), primeiraPostagem.getTempo());
			
			intervaloDeTempo.setIntervaloDeTempo(intervaloDeTempo.getIntervaloDeTempo()/(postagens.size() - 1));
			
			return intervaloDeTempo.toString() ;
		} else 
			throw new NaoHouvePostagemAindaException("Não houve postagens ainda");
	}


	public List<Postagem> getPostagensRecentes() {
		List<Postagem> postagensRecentes = new ArrayList<Postagem>();
		int contador = 1;
		while(contador <= 10 && postagens.size() >= contador){
			postagensRecentes.add(postagens.get(postagens.size() - contador));
			contador++;
		}
		return postagensRecentes;
	}
}
 


