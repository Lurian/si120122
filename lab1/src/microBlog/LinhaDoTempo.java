package microBlog;

import java.util.LinkedList;
import java.util.List;

public class LinhaDoTempo {

	List<Postagem> postagens;
	
	public LinhaDoTempo() {
		postagens = new LinkedList<Postagem>();
	}
	

	public void addPostagem(String link) {
		postagens.add(new Postagem(link));
		
	}

	public String getUltimaPostagem() {
		if(postagens.size() > 0)
			return postagens.get(postagens.size() - 1).getLink();
		else 
			return "Não houve postagens ainda";
	}

}
