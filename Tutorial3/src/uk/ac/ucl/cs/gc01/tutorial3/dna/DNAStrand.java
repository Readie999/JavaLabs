package uk.ac.ucl.cs.gc01.tutorial3.dna;

import java.util.regex.Pattern;

public class DNAStrand {
	private String dna;

	public DNAStrand(String dna) {
		this.dna = dna;

	}

	public boolean isValidDNA() {
		if (Pattern.matches("[ACGT]+", dna)) {
			return true;
		} else {
			return false;
		}
	}

	public String complementWC() {
		String str = "";
		for (int i = 0; i < dna.length(); i++) {
			Character c = dna.charAt(i);
			if (c == 'A') {
				str = str + 'T';
			} else if (c == 'G') {
				str = str + 'C';
			} else if (c == 'T') {
				str = str + 'A';
			} else if (c == 'C') {
				str = str + 'G';
			} else {
				str = str + c;
			}
		}

		return str;
	}

	public String palindromeWC() {
		// want the reverse of the complement
		String complement = complementWC();
		// first call the complementWC method -
		StringBuilder reverse = new StringBuilder(complement);
		reverse.reverse();
		// use the reverse method within the string builder class
		String rev = reverse.toString();
		return rev;
	}

	public boolean containsSequence(String seq) {
		if (dna.contains(seq)) {
			return true;
		} else {
			return false;

		}
	}

	public String toString() {
		/*String sh = "" + dna.charAt(0);
		for (int i = 1; i < dna.length(); i++) {
			Character ch = dna.charAt(i);
			sh = sh + "-" + ch;
		}*/
		return dna;
	}
}
