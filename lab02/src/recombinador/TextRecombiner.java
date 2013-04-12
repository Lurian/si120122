package recombinador;

import exception.ThereAreNoMoreLinesException;
import sistema.Text;

public interface TextRecombiner {
	public String getLine() throws ThereAreNoMoreLinesException;
	public void setText(Text texto);
	public boolean hasMoreLines();

}
