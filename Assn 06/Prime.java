// Author:	Matthew Morgan
// Date:	3 October 2016
// Purpose: This program displays all prime integers up to an integer that
// is specified by the user

import java.util.*;

public class Prime {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String result = "";
		int intCur = 2, userInt;
		boolean flagPrime = true;
		
		// Print instruction and get user input
		System.out.print("Enter an integer (2 or above): ");
		userInt = keyboard.nextInt();
		
		if (userInt < 2)
			result = "Invalid integer.";
		else {		
			result = "The prime numbers up to your integer are:";
			
			// Loop through all integers in ascending order
			while(intCur <= userInt) {
				// Loop that tests prime property
				// Prime property: From 2 to i-1, userInt cannot divide evenly
				for(int i=2; i<intCur-1; i++)
					if (intCur % i == 0)
						flagPrime = false;
				
				// Append integer (if prime) and prepare for next iteration
				if (flagPrime)
					result = result + "\n" + Integer.toString(intCur);
				flagPrime = true;
				intCur++;
			}
		}
		
		// Print result
		System.out.println("\n" + result);
		
		// Close keyboard
		keyboard.close();

	}

}
