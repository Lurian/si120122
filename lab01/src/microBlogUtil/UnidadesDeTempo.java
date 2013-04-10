package microBlogUtil;

public enum UnidadesDeTempo {
		MILISEGUNDO,SEGUNDO,MINUTO,HORA,DIA,SEMANA,MES,ANO;
		
		private String unidadeDeTempo;
		
		public String getStringUnidadeDeTempo(long intervaloDeTempo){
			switch (this) {
			case MILISEGUNDO:
				return (intervaloDeTempo > 1) ? "Milisegundos" : "Milisegundo";		
			case SEGUNDO:
				return (intervaloDeTempo > 1) ? "Segundos" : "Segundo";	
			case MINUTO:
				return (intervaloDeTempo > 1) ? "Minutos" : "Minuto";	
			case HORA:
				return (intervaloDeTempo > 1) ? "Horas" : "Hora";	
			case DIA:
				return (intervaloDeTempo > 1) ? "Dias" : "Dia";	
			case SEMANA:
				return (intervaloDeTempo > 1) ? "Semanas" : "Semana";	
			case MES:			
				return (intervaloDeTempo > 1) ? "Meses" : "Mes";	
			case ANO:			
				return (intervaloDeTempo > 1) ? "Anos" : "Ano";	
			}
			return "";
		}

		@Override
		public String toString() {
			return unidadeDeTempo;
		}
}
