package recombinador;

import java.util.Random;

import sistema.Text;
import exception.ThereAreNoMoreLinesException;

public class RandomRecombinerWithRepetition implements TextRecombiner{

	private Text text;
	private int numberOfLines;
	@Override
	public String getLine() throws ThereAreNoMoreLinesException {
		Random rand = new Random();
		return text.getLine(rand.nextInt(numberOfLines));
	}

	@Override
	public void setText(Text texto) {
		this.text = texto;
		this.numberOfLines = texto.getNumberOfLines();
	}

	@Override
	public boolean hasMoreLines() {
		return true;
	}

}
