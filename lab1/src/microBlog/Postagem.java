package microBlog;

import java.util.GregorianCalendar;

public class Postagem {

	private int mes;
	private int ano;
	private int dia;
	private int minuto;
	private int hora;
	private String link;

	public Postagem(String link) {
		this.link = link;
		this.hora = GregorianCalendar.HOUR;
		this.minuto = GregorianCalendar.MINUTE;
		this.dia = GregorianCalendar.DAY_OF_MONTH;
		this.mes = GregorianCalendar.MONTH;
		this.ano = GregorianCalendar.YEAR;
	}

	public int getMes() {
		return mes;
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
