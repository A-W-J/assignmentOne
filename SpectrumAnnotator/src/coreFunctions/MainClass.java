package coreFunctions;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		String specFile = "C:\\Users\\alexw\\Documents\\Ohio State\\Searle Lab\\Projects\\assignmentOne\\spectrum.txt";
		String uniFile = "C:\\Users\\alexw\\Documents\\Ohio State\\Searle Lab\\Projects\\assignmentOne\\modified_spectrum.txt";
		Spectrum spec = Spectrum.readSpectrum(specFile);
		ModSpectrum modSpec = ModSpectrum.readSpectrum(uniFile);
		Matches matchedPeaks = Matches.buildMatchObject(modSpec.getMasses(), spec.getMasses());
		AnnotatedSpectrum anno = AnnotatedSpectrum.annotateSpectrum(modSpec, matchedPeaks);
		int index = anno.getMasses().length;
		for(int i = 0; i < index; i++) {
			double mass = anno.getMasses()[i];
			String mod = anno.getMods()[i];
			String seq = anno.getSequences()[i];
			System.out.println(mass + "     " + mod + "     " + seq);
		}
	}

}