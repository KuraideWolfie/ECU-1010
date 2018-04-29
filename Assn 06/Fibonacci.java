// Author:	Matthew Morgan
// Date:	3 October 2016
// Purpose: This program will calculate and print a specific number in the
// Fibonacci sequence as specified by the user

import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String result = "";
		int fibCount, fibPrevA, fibPrevB, fibCurrent;
		fibPrevA = 1;
		fibPrevB = 1;
		fibCurrent = 0;
		
		// Print instruction and get user input
		System.out.print("Enter an integer (1 - 46): ");
		fibCount = keyboard.nextInt();
		
		// CHECK: Is user input valid (in permitted range)
		if (fibCount < 1 || fibCount > 46) {
			result = "Not a valid number.";
		}
		else {
			// Compose result prefix based on user-entered term
			// 11, 12, and 13 are special cases
			if (fibCount == 11 || fibCount == 12 || fibCount == 13)
				result = "The " + fibCount + "th number in the Fibonacci sequence is: ";
			else			
				switch(fibCount % 10) {
					case 1:
						result = "The " + fibCount + "st number in the Fibonacci sequence is: ";
						break;
					case 2:
						result = "The " + fibCount + "nd number in the Fibonacci sequence is: ";
						break;
					case 3:
						result = "The " + fibCount + "rd number in the Fibonacci sequence is: ";
						break;
					default:
						result = "The " + fibCount + "th number in the Fibonacci sequence is: ";
				}
			
			// CHECK: Special cases for the Fibonacci terms (1st and 2nd)
			if (fibCount <= 2)
				result = result + "1";
			else {
				// Loop calculation of Fibonacci terms
				// Loop ends when specified term is reached
				while(fibCount > 2) {
					fibCurrent = fibPrevA + fibPrevB;
					fibPrevA = fibPrevB;
					fibPrevB = fibCurrent;
					fibCount--;
				}
				
				// Set suffix of result
				result = result + Integer.toString(fibCurrent);
			}
		}
		
		// Print result
		System.out.println("\n" + result);
		
		// Close the keyboard
		keyboard.close();

	}

}
