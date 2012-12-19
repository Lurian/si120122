package microBlog;

import java.util.GregorianCalendar;

public class Postagem {

	private int mes;
	private int ano;
	private int dia;
	private int minuto;
	private int hora;
	private String link;

	public Postagem(String link, int mes, int ano, int dia, int minuto, int hora) {
		this.link = link;
		this.mes = mes;
		this.ano = ano;
		this.dia = dia;
		this.minuto = minuto;
		this.hora = hora;	
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getAno() {
		return ano;
	}

	public int getDia() {
		return dia;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getHora() {
		return hora;
	}

	public String getLink() {
		return link;
	}

}
