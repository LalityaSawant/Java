
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part3 {

	public boolean twoOccurrences(String stringa, String stringb) {
		boolean result = false;
		int firstOcc, secondOcc = 0;

		/*
		 * This method returns true if stringa appears at least twice in stringb,
		 * otherwise it returns false.
		 */

		firstOcc = stringb.indexOf(stringa);
		// System.out.println(firstOcc);

		secondOcc = stringb.indexOf(stringa, (firstOcc + 1));
		// System.out.println(secondOcc);

		if (secondOcc != -1) {
			result = true;
		}
		return result;
	}

	public void testing() {
		Part3 p3 = new Part3();
		String stringa = "an";
		String stringb = "banana";
		boolean result = false;

		result = p3.twoOccurrences(stringa, stringb);
		System.out.println("Second occurance of " + stringa + " in " + stringb + " is " + result);

		stringa = "zoo";
		stringb = "forest";

		result = p3.twoOccurrences(stringa, stringb);
		System.out.println("Second occurance of " + stringa + " in " + stringb + " is " + result);

		String opString = "";
		opString = p3.lastPart(stringa, stringb);
		System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + opString);

		stringa = "zoo";
		stringb = "forest";
		opString = p3.lastPart(stringa, stringb);
		System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + opString);
	}

	public String lastPart(String stringa, String stringb) {
		/*
		 * This method finds the first occurrence of stringa in stringb, and returns the
		 * part of stringb that follows stringa. If stringa does not occur in stringb,
		 * then return stringb.
		 */
		String result = stringb;
		int firstOcc = stringb.indexOf(stringa);
		// System.out.println(firstOcc);

		if (firstOcc != -1) {
			result = stringb.substring(firstOcc + stringa.length());
		}

		return result;

	}

}

