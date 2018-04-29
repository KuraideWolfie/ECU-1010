// Author:	Matthew Morgan
// Date:	20 September 2016

import java.util.*;

public class WordFilter {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String userInput;
		
		// Get user input
		System.out.println("Please type a sentence below:");
		userInput = keyboard.nextLine().toLowerCase();
		
		// Print appropriate statement based upon profanity
		if (userInput.contains("dog") || userInput.contains("cat") || userInput.contains("llama")) {
			// Print rejection statement
			System.out.println("\n" + "Sentence is rejected.");
		}
		else {
			// Print acceptance statement
			System.out.println("\n" + "Sentence is OK.");
		}

		// Close the scanner
		keyboard.close();

	}

}
