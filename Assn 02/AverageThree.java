// Author:	Matthew Morgan
// Date:	5 September 2016

import java.util.*;

public class AverageThree {

	public static void main(String[] args) {

		// Variable declaration
		float assign1, assign2, assign3, assignAvg;
		Scanner keyboard = new Scanner(System.in);
		
		// Display instructions on screen
		System.out.println("I will average three assignment grades.");
		
		// Get user input for first assignment
		System.out.print("Enter the grade for assignment 1: ");
		assign1 = keyboard.nextFloat();
		
		// Get user input for second assignment
		System.out.print("Enter the grade for assignment 2: ");
		assign2 = keyboard.nextFloat();
		
		// Get user input for third assignment
		System.out.print("Enter the grade for assignment 3: ");
		assign3 = keyboard.nextFloat();
		
		// Calculate average and print it to the screen
		assignAvg = (assign1 + assign2 + assign3) / 3;
		System.out.println("The average of these grades is: " + assignAvg);
		
		// Close scanner
		keyboard.close();
		
	}

}
