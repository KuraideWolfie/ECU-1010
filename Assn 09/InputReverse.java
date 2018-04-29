/*
 * Author:	Matthew Morgan
 * Date:	9 November 2016
 * Purpose: Gets 10 integers from the user and then displays them in reverse order
 */

import java.util.*;

public class InputReverse {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		int[] userInput = new int[10];
		
		// Get user input
		for(int i=0; i<userInput.length; i++) {
			System.out.print("Enter integer #"+(i+1)+": ");
			userInput[i] = keyboard.nextInt();
		}
		
		// Display in reverse order
		System.out.println("\nIn reverse order:");
		for(int i=0; i<userInput.length; i++)
			System.out.println(userInput[userInput.length-1-i]);

		// Close keyboard
		keyboard.close();
		
	}

}
