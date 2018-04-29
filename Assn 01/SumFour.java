// Author:	Matthew Morgan
// Date:	27 August 2016
// Desc:	This simple Java program calculates the sum of four integers

import java.util.*;

public class SumFour {

	public static void main(String[] args) {

		// Print introductory message to the screen
		System.out.println("Hello out there.");
		System.out.println("I will add four numbers for you.");
		System.out.println("Enter four whole numbers on a line:");
		
		// Initialize four integers and user input scanner
		int n1, n2, n3, n4;
		Scanner keyboard = new Scanner(System. in);
		
		// Gather user input (the four integers)
		n1 = keyboard.nextInt();
		n2 = keyboard.nextInt();
		n3 = keyboard.nextInt();
		n4 = keyboard.nextInt();
		
		// Print the summation of the integers to the screen
		System.out.println("The sum of those four numbers is:");
		System.out.println( n1 + n2 + n3 + n4 );
		
		//Close user input scanner
		keyboard.close();

	}

}
