/*
 * Author:	Matthew Morgan
 * Date:	16 November 2016
 * This program reads a line of text, counts the frequency of the different
 * letters in the text, and then displays the frequenceis on-screen
 */

import java.util.*;

public class CharCount {
	
	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		
		// Retrieve and process user input
		System.out.println("Enter a line of text below:");
		printResults( countLetters(keyboard.nextLine().toLowerCase()) );
		
		// Close keyboard
		keyboard.close();
		
	}
	
	/**
	 * Counts the frequency of different letters in a string
	 * @param txt The line of text to count letters for
	 * @return An array containing the frequencies of all letters
	 */
	public static int[] countLetters(String txt) {
		
		// Variable declaration
		int[] chrCount = new int[26];
		
		// Process text
		for(int i = txt.length()-1; i>=0; i--)
			if (txt.charAt(i) >= 'a' && txt.charAt(i) <= 'z')
				chrCount[ pos(txt.charAt(i)) ]++;
		
		// Return the array's identifier/pointer
		return chrCount;
		
	}
	
	/**
	 * Returns an identifier (0-25 for a-z) for the specified character
	 * @param chr The character to return an identifier for
	 * @return An integer from 0 to 25 that represents the character
	 */
	public static int pos(char chr) {
		
		return chr-'a';
		
	}
	
	/**
	 * Prints results of the letter frequencies to the screen
	 * @param chrCount An array containing a list of character frequencies
	 */
	public static void printResults(int[] chrCount) {
		
		// Print the list of frequencies for any letters in string to screen
		System.out.println("\nLetter frequencies:");
		for(int i=0; i<chrCount.length; i++)
			if (chrCount[i] != 0)
				System.out.println((char)('a'+i) + " - " + chrCount[i]);
		
	}

}
