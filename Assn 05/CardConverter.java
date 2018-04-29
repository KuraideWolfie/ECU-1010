// Author:	Matthew Morgan
// Date:	27 September 2016
// Purpose: This program outputs a full card description based on
// 2-3 characters entered by the user.

import java.util.*;

public class CardConverter {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String userInput, result = "";

		// Print instructions
		System.out.println("Enter a card value (Ex: 2K).");
		System.out.println("Value: 2-10, A, J, Q, or K");
		System.out.println("Suits: D, H, S, C");
		System.out.println("----------------------------------");
		System.out.print("Enter your card: ");
		
		// Get user input
		userInput = keyboard.nextLine().toUpperCase();
		System.out.println("----------------------------------");
		
		// Append value to result string
		switch (userInput.length()) {
			case 2:
				// User input is a number [2-9] or a letter [A, J, Q, K]
				switch(userInput.charAt(0)) {
					case 'A':
						result = "Ace of ";
						break;
					case 'J':
						result = "Jack of ";
						break;
					case 'Q':
						result = "Queen of ";
						break;
					case 'K':
						result = "King of ";
						break;
					default:
						result = userInput.charAt(0) + " of ";
						break;
				}
				break;
			case 3:
				// Value is 10
				result = "10 of ";
				break;
		}
		
		// Append suit to result string (based on last character in string)
		switch(userInput.charAt(userInput.length()-1)) {
			case 'S':
				result = result + "Spades";
				break;
			case 'H':
				result = result + "Hearts";
				break;
			case 'D':
				result = result + "Diamonds";
				break;
			case 'C':
				result = result + "Clubs";
				break;
		}
		
		// Print result
		System.out.println("Your card is the " + result);
		
		// Close keyboard
		keyboard.close();
		
	}

}
