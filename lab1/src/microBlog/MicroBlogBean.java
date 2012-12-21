package microBlog;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean(name="microBlog")
public class MicroBlogBean {
	
	private String linkASerPostado = "Use https//: ou htttp//:";
	private List<Postagem> postagensRecentes = new ArrayList<Postagem>();
	private MicroBlog microBlog = new MicroBlog();


	public String postaLink(){	
		try {
			microBlog.postaLink(linkASerPostado);
			return "YYeeehaaa!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Postagem> getPostagensRecentes() {
		return microBlog.getPostagensRecentes();
	}	
	

	public String getLinkASerPostado() {
		return linkASerPostado;
	}

	public void setLinkASerPostado(String linkASerPostado) {
		this.linkASerPostado = linkASerPostado;
	}

}
