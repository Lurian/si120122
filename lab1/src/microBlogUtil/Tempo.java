package microBlogUtil;

import java.util.GregorianCalendar;

public class Tempo {
	GregorianCalendar data;

	public Tempo(GregorianCalendar data) {
		this.data = data;
	}

	public int getMes() {
		return data.get(GregorianCalendar.MONTH);
	}

	public int getAno() {
		return data.get(GregorianCalendar.YEAR);
	}

	public int getDia() {
		return data.get(GregorianCalendar.DAY_OF_MONTH);
	}

	public int getMinuto() {
		return data.get(GregorianCalendar.MINUTE);
	}

	public int getHora() {
		return data.get(GregorianCalendar.HOUR_OF_DAY);
	}

	public int getSegundo() {
		return data.get(GregorianCalendar.SECOND);
	}

	public GregorianCalendar getData() {
		return data;
	}
}
