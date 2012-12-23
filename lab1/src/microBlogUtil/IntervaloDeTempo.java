package microBlogUtil;

import java.text.NumberFormat;

public class IntervaloDeTempo {
	private long intervaloEmMilisegundos;
	
	public IntervaloDeTempo(Tempo tempoA, Tempo tempoB){
		this.intervaloEmMilisegundos = Math.abs(tempoA.getData().getTimeInMillis() - tempoB.getData().getTimeInMillis());
	}

	public long getIntervaloDeTempo() {
		return intervaloEmMilisegundos;
	}

	public void setIntervaloDeTempo(long intervaloEmMilisegundos) {
		this.intervaloEmMilisegundos = intervaloEmMilisegundos;
	}
	
	@Override
	public String toString() {
		if(intervaloEmMilisegundos > 1000){
			
			long intervaloEmSegundos = intervaloEmMilisegundos / 1000;
			if(intervaloEmSegundos > 60){
				
				long intervaloEmMinutos = intervaloEmSegundos / 60;
				if(intervaloEmMinutos > 60){
					
					long intervaloEmHoras = intervaloEmMinutos / 60;
					if(intervaloEmHoras > 24){
						
						long intervaloEmDias = intervaloEmHoras / 24;
						if(intervaloEmDias > 7){
							
							long intervaloEmSemanas = intervaloEmDias / 7;
							if(intervaloEmDias > 30 ){
								
								long intervaloEmMeses = intervaloEmDias / 30;
								if(intervaloEmMeses > 12){							
									
									long intervaloEmAnos = intervaloEmMeses / 12;
									
									return intervaloEmAnos + " " + UnidadesDeTempo.ANO.getStringUnidadeDeTempo(intervaloEmAnos);						
								}	
								return intervaloEmMeses + " " + UnidadesDeTempo.MES.getStringUnidadeDeTempo(intervaloEmMeses);
							}
							return  intervaloEmSemanas + " " + UnidadesDeTempo.SEMANA.getStringUnidadeDeTempo(intervaloEmSemanas);
						}
						return  intervaloEmDias + " " + UnidadesDeTempo.DIA.getStringUnidadeDeTempo(intervaloEmDias);
					}
					return  intervaloEmHoras + " " + UnidadesDeTempo.HORA.getStringUnidadeDeTempo(intervaloEmHoras);
				}
				return intervaloEmMinutos + " " + UnidadesDeTempo.MINUTO.getStringUnidadeDeTempo(intervaloEmMinutos);
			}
			return  intervaloEmSegundos + " " + UnidadesDeTempo.SEGUNDO.getStringUnidadeDeTempo(intervaloEmSegundos);
		}
		return  intervaloEmMilisegundos + " " + UnidadesDeTempo.MILISEGUNDO.getStringUnidadeDeTempo(intervaloEmMilisegundos);
	}
}
