/*
 * Author:	Matthew Morgan
 * Date:	9 November 2016
 * Purpose: Gets 10 integers from the user and then displays the average.
 * Afterward, displays which integers are greater than the average
 */

import java.util.*;

public class Average {

	public static void main(String[] args) {

		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		int[] userInput = new int[10];
		double average = 0.0;
		int aboveAverage = 0;
		String aboveAverageStr = "";
		
		// Get user input
		for(int i=0; i<userInput.length; i++) {
			System.out.print("Enter integer #" + (i+1) + ": ");
			userInput[i] = keyboard.nextInt();
			average += userInput[i];
		}
		
		// Calculate and display average
		average /= userInput.length;
		System.out.println("\nThe average of these integers is: "+average);
		
		// Display integers greater than average
		for(int i=0; i<userInput.length; i++)
			if (userInput[i] > average) {
				aboveAverage++;
				aboveAverageStr += "\n" + userInput[i];
			}
		System.out.println("Integers above average: " + aboveAverage);
		System.out.println("Those integers are:" + aboveAverageStr);
		
		// Close keyboard
		keyboard.close();
		
	}

}
