package coreFunctions;

import java.io.IOException;
import java.util.StringTokenizer;

public class ModSpectrum{
	private final double[] masses;
	private final String[] mods;
	private final String[] sequences;
	
	public ModSpectrum(double[] masses, String[] mods, String[] sequences) {
		super();
		this.masses = masses;
		this.mods = mods;
		this.sequences = sequences;
		
	}
	public double[] getMasses() {
		return masses;
	}
	public String[] getMods() {
		return mods;
	}
	public String[] getSequences() {
		return sequences;
	}
	
	public static ModSpectrum readSpectrum(String filename) throws IOException {
		//using a string tokenizer, we can leverage previous code
		String[] lines = SeqArray.readSequences(filename);
		//then we allocate new arrays equal to the number of lines
		double[] masses = new double[lines.length];
		String[] mods = new String[lines.length];
		String[] sequences = new String[lines.length];
		//here, we need to set up a counter
		int counter = 0;
		//instead of using a scanner, we use a tokenizer to operate on each string and
		//parse out the values
		for(String line:lines) {
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreTokens()) {
				masses[counter] = (double)Double.valueOf(st.nextToken());
				mods[counter] = String.valueOf(st.nextToken());
				sequences[counter] = String.valueOf(st.nextToken());
				counter = counter + 1;
			}
		}
		return new ModSpectrum(masses, mods, sequences);
	}
}