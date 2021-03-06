package uk.ac.ucl.cs.gc01.tutorial3.dna;

public class DNAStrandTester {
	public static void main(String[] args) {
		
	DNAStrand dna1 = new DNAStrand("CAGT");
	DNAStrand dna2 = new DNAStrand("TGAC");
	summarise(dna1);
	summarise(dna2);
	}
	public static void summarise(DNAStrand dna) {
		System.out.println("Original DNA Sequence: " + dna); 
		if (dna.isValidDNA()) {
		System.out.println("Is valid");
		System.out.println("Complement: " + dna.complementWC());
		System.out.println("WC Palindrome: " +
		 dna.palindromeWC());
		} else {
		System.out.println("Not Valid DNA");
		}
		}
}