// Author:	Matthew Morgan
// Date:	12 September 2016

import java.util.*;

public class HateChange {

	public static void main(String[] args) {

		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String userInput, pieceFirst, pieceLast;
		int indexFirst, indexLast;
		
		// Display instructions and get user input
		System.out.println("Enter a sentence containing the word \"hate\":");
		userInput = keyboard.nextLine();
		
		// Get start and end index of first occurrence of "hate"
		// Separate sentence at these points
		indexFirst = userInput.indexOf("hate");
		indexLast = indexFirst + 4;
		pieceFirst = userInput.substring(0, indexFirst);
		pieceLast = userInput.substring(indexLast);
		
		// Display result
		System.out.println("\nYour revised sentence is:\n" + pieceFirst + "love" + pieceLast);
		
		// Close scanner
		keyboard.close();
		
	}

}
