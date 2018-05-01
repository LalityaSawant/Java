
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part1 {

	public void testSimpleGene() {
		/*
		 *The strings should have specific test cases, such as: 
		 *DNA with no “ATG”, 
		 *DNA with no “TAA”, 
		 *DNA with no “ATG” or “TAA”, 
		 *DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), 
		 *and DNA with ATG, TAA and the substring between them is not a multiple of 3. 
		 */
		
		String string1 = "XXXYYYTAAZZZ";
		String string2 = "XXXATGYYYZZZ";
		String string3 = "XXXYYYZZZ";
		String string4 = "XXXATGYYYTAAZZZ";
		String string5 = "XXXATGYYYMMTAAZZZ";
		
		String dnaStrand = "";
		
		Part1 p1 = new Part1();
		
		dnaStrand = p1.findSimpleGene(string1);		
		System.out.println("DNA in your string1 " + string1 + " is : " + dnaStrand);
		
		dnaStrand = p1.findSimpleGene(string2);		
		System.out.println("DNA in your string2 " + string2 + " is : " + dnaStrand);
		
		dnaStrand = p1.findSimpleGene(string3);		
		System.out.println("DNA in your string3 " + string3 + " is : " + dnaStrand);
		
		dnaStrand = p1.findSimpleGene(string4);		
		System.out.println("DNA in your string4 " + string4 + " is : " + dnaStrand);
		
		dnaStrand = p1.findSimpleGene(string5);		
		System.out.println("DNA in your string5 " + string5 + " is : " + dnaStrand);
	
}
	
	public String findSimpleGene(String dna) {
		String dnaStrand = "";
		int strIndx = 0;
		int endIndx = 0;

		/*
		 * Finds the index position of the start codon “ATG”. If there is no “ATG”,
		 * return the empty string.
		 *
		 * Finds the index position of the first stop codon “TAA” appearing after the
		 * “ATG” that was found. If there is no such “TAA”, return the empty string.
		 * 
		 * If the length of the substring between the “ATG” and “TAA” is a multiple of
		 * 3, then return the substring that starts with that “ATG” and ends with that
		 * “TAA”.
		 */

		strIndx = dna.indexOf("ATG");

		if (strIndx == -1) {
			return dnaStrand;
		}

		endIndx = (dna.indexOf("TAA") + 3);

		if (endIndx == -1) {
			return dnaStrand;
		}

		if ((endIndx > strIndx) && ((endIndx - strIndx) % 3) == 0) {
			dnaStrand = dna.substring(strIndx, endIndx);
			return dnaStrand;
		}

		return dnaStrand;
	}

	public static void main(String args[]) {
		Part1 p1 = new Part1();
		
		p1.testSimpleGene();
		
	}
}

