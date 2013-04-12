package recombinador;

import exception.ThereAreNoMoreLinesException;
import sistema.Text;

public class InverseRecombiner implements TextRecombiner {
	Text text;
	final int startValue = Integer.MAX_VALUE;
	int currentLine = startValue;
	@Override
	public String getLine() throws ThereAreNoMoreLinesException {
		if(currentLine == startValue){
			currentLine = text.getNumberOfLines() - 1;
		}else if(currentLine == -1){
			throw new ThereAreNoMoreLinesException("There are no more lines left!");
		}
		return text.getLine(currentLine--);
	}

	@Override
	public void setText(Text text) {
		this.text = text;
	}

	@Override
	public boolean hasMoreLines() {
		return currentLine == -1;
	}

}
