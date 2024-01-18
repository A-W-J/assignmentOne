package coreFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matches {
	final Double[] matchIdentities;
	public Matches(Double[] matchIdentities) {
		super();
		this.matchIdentities = matchIdentities;
	}
	public Double[] getMatchIdentities() {
		return matchIdentities;
	}
	
	public static Matches buildMatchObject(double[] uniprotMasses, double[] spectrumMasses) {
		//we don't know how many matches we will have, so we will start with a dynamic array
		//List<Long> tempMatchIdentities = new ArrayList<Long>();
		//bit of a waste of time, but it allows for some flexibility
		List<double[]> spectrumList = Arrays.asList(spectrumMasses);
		ArrayList<Double> tempMatchIdentities = new ArrayList<Double>();
		//we're having a hard time implementing binary searches on decimal values; because time is
		//rather limited, we'll implement a linear search
		for(double uniprotMass:uniprotMasses) {
			//int dummy = Arrays.binarySearch(spectrumMasses, uniprotMass);
			for(double spectrumMass:spectrumMasses) {
				double diff = Math.abs(uniprotMass - spectrumMass);
				if(diff < 1) {
					tempMatchIdentities.add(uniprotMass);
				}
			}
		}
		Double[] matchIdentities = tempMatchIdentities.toArray(new Double[0]);
		//Long[] matchIdentities = tempMatchIdentities.toArray(new Long[0]);
		return new Matches(matchIdentities);
	}

}
