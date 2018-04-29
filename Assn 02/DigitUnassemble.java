// Author:	Matthew Morgan
// Date:	5 September 2016

import java.util.*;

public class DigitUnassemble {

	public static void main(String[] args) {

		// Variable declaration
		int hundreds, tens, ones, originalNum;
		Scanner keyboard = new Scanner(System.in);

		// Print introductory message to the screen
		System.out.println("I will unassemble a three-digit number for you.");
		System.out.println("-----------------------------------------------");

		// Get user input for original number
		System.out.print("Enter a three-digit positive integer: ");
		originalNum = keyboard.nextInt();
		
		// Unassemble integer
		hundreds = originalNum / 100;
		tens = (originalNum % 100) / 10;
		ones = ((originalNum % 100) % 10);
		
		// Print results to screen
		System.out.println("-----------------------------------------------");
		System.out.println("The hundreds digit is: " + hundreds);
		System.out.println("The tens digit is    : " + tens);
		System.out.println("The ones digit is    : " + ones);
		
		// Close scanner
		keyboard.close();

	}

}
