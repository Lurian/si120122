package sistema;

import java.util.Arrays;
import java.util.List;

public class Text {
	List<String> words;
	final int INTRO_NUM_WORDS = 12;
	final int LINE_NUM_WORDS = 10;
	public Text(String text){
		this.words = Arrays.asList(text.split("\\s+"));
	}
	
	public String getTextIntro(){
		if (words.size() < INTRO_NUM_WORDS){
			return lineToString(words);
		}
		return lineToString(words.subList(0, INTRO_NUM_WORDS));
	}
	
	private String lineToString(List<String> wordList){
		String msg = "";
		for(String word : wordList){
			msg += word + " ";
		}
		return msg;
	}
	
	public int getNumberOfLines(){
		int linhas = (words.size()/LINE_NUM_WORDS) + 1;
		return linhas;
	}
	
	
	public String getLine(int lineNumber){
		
		int startIndex = lineNumber*LINE_NUM_WORDS;
		int endIndex =  (lineNumber +1)*LINE_NUM_WORDS < words.size() ? (lineNumber +1)*LINE_NUM_WORDS : words.size();
		List<String> wordList = words.subList( startIndex,  endIndex);
		
		String returnLine = lineToString(wordList);
		return returnLine;
	}
	
	@Override
	public String toString() {
		return getTextIntro();
	}
}
