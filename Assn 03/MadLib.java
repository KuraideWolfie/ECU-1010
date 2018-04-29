// Author:	Matthew Morgan
// Date:	12 September 2016

import java.util.*;

public class MadLib {

	public static void main(String[] args) {

		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String libAdj, libNoun, libAni, libNoise;
		String output =
				"<ADJ> Macdonald had a <NOUN>, E-I-E-I-O\n"
				+ "and on that <NOUN> he had a(n) <ANI>, E-I-E-I-O\n"
				+ "with a <NOISE> <NOISE> here\n"
				+ "and a <NOISE> <NOISE> there,\n"
				+ "here a <NOISE>, there a <NOISE>,\n"
				+ "everywhere a <NOISE> <NOISE>,\n"
				+ "<ADJ> Macdonald had a <NOUN>, E-I-E-I-O.";
		
		// Obtain user input (adjective)
		System.out.print("Enter an adjective: ");
		libAdj = keyboard.next().toUpperCase();
		
		// Obtain user input (noun)
		System.out.print("Enter a noun: ");
		libNoun = keyboard.next().toUpperCase();
		
		// Obtain user input (animal)
		System.out.print("Enter an animal: ");
		libAni = keyboard.next().toUpperCase();
		
		// Obtain user input (noise)
		System.out.print("Enter a noise: ");
		libNoise = keyboard.next().toUpperCase();
		
		// Insert user input		
		output = output.replace("<ADJ>", libAdj);
		output = output.replace("<NOUN>", libNoun);
		output = output.replace("<ANI>", libAni);
		output = output.replace("<NOISE>", libNoise);
		
		// Display final result
		System.out.println("\n" + output);
		
		// Close scanner
		keyboard.close();
		
	}

}
