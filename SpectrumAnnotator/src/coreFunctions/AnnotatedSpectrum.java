package coreFunctions;

public class AnnotatedSpectrum {
	private final double[] masses;
	private final String[] mods;
	private final String[] sequences;
	
	public AnnotatedSpectrum(double[] masses, String[] mods, String[] sequences) {
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
	
	//this is an extremely inefficient method of completing this, however, we can always work on
	//optimizing it in the future
	public static AnnotatedSpectrum annotateSpectrum(ModSpectrum modifiedSpectrum, Matches matchedPeaks) {
		Double[] matched = matchedPeaks.getMatchIdentities();
		//we do know that we will be grabbing elements equal to the number of matches, so we can
		//set up static arrays ahead of time
		double[] masses = new double[matched.length];
		String[] mods = new String[matched.length];
		String[] sequences = new String[matched.length];
		//unfortunately, we will be using another linear search here
		int counter = 0;
		for(double match:matched) {
			//we don't iterate over the 
			for(int i=0; i < modifiedSpectrum.getMasses().length; i++) {
				double mass = modifiedSpectrum.getMasses()[i];
				if(match == mass) {
					masses[counter] = mass;
					mods[counter] = modifiedSpectrum.getMods()[i];
					sequences[counter] = modifiedSpectrum.getSequences()[i];
					counter = counter + 1;
					break;
				}
			}
			
		}
		return new AnnotatedSpectrum(masses, mods, sequences);
	}
	

}
