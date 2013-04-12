package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.ThereAreNoMoreLinesException;
import exception.InvalidRecombinatorException;

import recombinador.RandomRecombinerWithRepetition;
import recombinador.RandomRecombinerWithoutRepetition;
import recombinador.TextRecombiner;
import recombinador.InverseRecombiner;

public class System {
	private List<Text> texts;
	private Map<String, TextRecombiner> recombiners;
	private TextRecombiner currentRecombiner;
	public System(){
		this.texts = new ArrayList<Text>();
		this.recombiners = new HashMap<String, TextRecombiner>();
		recombiners.put("Recombinador Inverso", new InverseRecombiner());
		recombiners.put("Recombinador Aleatorio com Repeticao",
				new RandomRecombinerWithRepetition());
		recombiners.put("Recombinador Aleatorio sem Repeticao",
				new RandomRecombinerWithoutRepetition());
	}

	public List<String> getRecombiners(){
		List<String> recombiners = new ArrayList<String>();
		recombiners.addAll(this.recombiners.keySet());
		return recombiners;
	}
	
	
	public List<Text> getTexts(){
		return texts;
	}
	
	public void setUpRecombiner(String recombinerKey, String textIntro) throws InvalidRecombinatorException{
		currentRecombiner = recombiners.get(recombinerKey);
		currentRecombiner.setText(matchTextIntro(textIntro));
		if(currentRecombiner == null){
			throw new InvalidRecombinatorException("Recombinador inexistente.");
		}
	}

	public void newTexto(String text){
		texts.add(new Text(text));
	}
	
	private Text matchTextIntro(String textIntro){
		for(Text texto : texts){
			if(texto.getTextIntro().equals(textIntro)) return texto;
		}
		return null;
	}
	
	
	public String getNewLine() throws ThereAreNoMoreLinesException{
		return currentRecombiner.getLine();
	}
}
