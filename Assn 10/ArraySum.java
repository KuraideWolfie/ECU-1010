/*
 * Author:	Matthew Morgan
 * Date:	16 November 2016
 * This program allows a user to specify, and enter, any number of integers
 * that will, consecutively, be summed together and their percentage of the
 * sum displayed
 */

import java.util.*;

public class ArraySum {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		int sum;

		// Get number of integers to enter from user
		System.out.print("How many integers will you enter? > ");
		int[] userIntList = new int [keyboard.nextInt()];
		System.out.println("Enter " + userIntList.length + " integers, one per line:");
		
		// Get all integers and sum them
		for(int i=0; i<userIntList.length; i++)
			userIntList[i] = keyboard.nextInt();
		sum = sumArray(userIntList);
		
		// Print sum and percentages
		System.out.println("\nThe sum is "+sum+".");
		System.out.print("The numbers are:");
		for(int i=0; i<userIntList.length; i++)
			System.out.printf("\n%d, which is %7.4f%% of the sum.", userIntList[i], (double)userIntList[i] / sum * 100);
		
		// Close keyboard
		keyboard.close();
		
	}
	
	/**
	 * Calculates the sum of all integers in an array
	 * @param array The array containing integers to be summed
	 * @return Summation of all integers in the array
	 */
	public static int sumArray(int[] array) {
		
		// Variable declaration
		int sum = 0;
		
		// Loop sum calculation
		for(int i=0; i<array.length; i++)
			sum += array[i];
		
		// Return sum
		return sum;
		
	}

}
