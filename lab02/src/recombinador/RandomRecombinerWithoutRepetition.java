package recombinador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sistema.Text;
import exception.ThereAreNoMoreLinesException;

public class RandomRecombinerWithoutRepetition implements TextRecombiner {

	private Text text;
	private int linesLeft = 0;
	private List<Integer> remainingIndexes;
	private Random generator = new Random();

	@Override
	public String getLine() throws ThereAreNoMoreLinesException {
		if (linesLeft == 0) {
			throw new ThereAreNoMoreLinesException("There are no more lines left!");
		}
		int index = generator.nextInt(linesLeft--);
		String linha = text.getLine(remainingIndexes.get(index));
		remainingIndexes.remove(index);
		return linha;
	}

	@Override
	public void setText(Text text) {
		this.text = text;
		this.linesLeft = text.getNumberOfLines();
		remainingIndexes = new ArrayList<Integer>();
		for(int i = 0 ; i < linesLeft ; i++){
			remainingIndexes.add(i);
		}
	}

	@Override
	public boolean hasMoreLines() {
		return linesLeft == 0;
	}

}
