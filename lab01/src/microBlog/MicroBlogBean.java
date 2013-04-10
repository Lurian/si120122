package microBlog;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import microBlogException.FormatoDeLinkIncorretoException;
import microBlogException.NaoHouvePostagemAindaException;

@SessionScoped
@ManagedBean(name="microBlog")
public class MicroBlogBean {
	
	private String linkASerPostado = "Use https//: ou htttp//:";
	private MicroBlog microBlog = new MicroBlog();
	private boolean formatoDeLinkInvalido = false;


	public String postaLink(){	
		try {
			microBlog.postaLink(linkASerPostado);
			formatoDeLinkInvalido = false;
			return "";
		} catch (FormatoDeLinkIncorretoException e) {
			formatoDeLinkInvalido = true;
			linkASerPostado = e.getMessage();
			return "";
		}
	}
	
	public boolean getFormatoDeLinkInvalido() {
		return formatoDeLinkInvalido;
	}
	
	public boolean isFormatoDeLinkInvalido() {
		return formatoDeLinkInvalido;
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
	
	public String getSiteMaisPostado(){
		try {
			return microBlog.getSiteMaisPostado();
		} catch (NaoHouvePostagemAindaException e) {
			return e.getMessage();
		}
	}
	
	public String getTempoMedioEntrePostagens(){
		try {
			return microBlog.getTempoMedioEntrePostagens();
		} catch (NaoHouvePostagemAindaException e) {
			return e.getMessage();
		}
	}

}
