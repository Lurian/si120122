package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "Recombinador")
public class RecombinadorBean {
		private String textoAtual;
		private String textoPreSelecionado;
		private List<String> recombinadores;
		private String recombinadorPreSelecionado;
		private String recombinadorAtual;
		private List<String> textos;
		
		
		public String getTextoAtual() {
			return textoAtual;
		}
		
		public void setTextoAtual(String textoAtual) {
			this.textoAtual = textoAtual;
		}
		
		public List<String> getTextos() {
			if(textos == null) {
				textos = new ArrayList<String>();
				textos.add("Amostra de Texto que possa conter uma faixa de doze palavras exatamente");
				textos.add("Amostra de Texto que talvez contenha uma faixa de doze palavras exatamente");
				textos.add("Amostra de Texto que contem exatas doze palavras bem contadas por mim");
			}
			return textos;
		}
		
		public void setTextos(List<String> textos) {
			this.textos = textos;
		}

		public String getTextoPreSelecionado() {
			return "Amostra de Texto que possa conter uma faixa de doze palavras exatamente";
		}

		public void setTextoPreSelecionado(String textoPreSelecionado) {
			this.textoPreSelecionado = textoPreSelecionado;
		}

		public String getRecombinadorAtual() {
			return recombinadorAtual;
		}

		public void setRecombinadorAtual(String recombinadorAtual) {
			this.recombinadorAtual = recombinadorAtual;
		}

		public List<String> getRecombinadores() {
			if(recombinadores == null) {
				recombinadores = new ArrayList<String>();
				recombinadores.add("Recombinador 1");
				recombinadores.add("Recombinador 2");
				recombinadores.add("Recombinador 3");
			}
			return recombinadores;
		}

		public void setRecombinadores(List<String> recombinadores) {
			this.recombinadores = recombinadores;
		}

		public String getRecombinadorPreSelecionado() {
			return "Recombinador 1";
		}

		public void setRecombinadorPreSelecionado(
				String recombinadorPreSelecionado) {
			this.recombinadorPreSelecionado = recombinadorPreSelecionado;
		}
}
