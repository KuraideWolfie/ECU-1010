// Author:	Matthew Morgan
// Date:	12 September 2016

import java.util.*;

public class URLParser {

	public static void main(String[] args) {

		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String urlInitial, urlRefine;
		int posLastSpace;
		
		// Display instruction and get user input
		System.out.println("Enter a web address:");
		urlInitial = keyboard.nextLine();
		
		// Process string to obtain page requested
		posLastSpace = urlInitial.lastIndexOf("/");
		urlRefine = urlInitial.substring(posLastSpace+1);
		
		// Display result
		System.out.println("\nThe web page that is being requested is:\n"+urlRefine);
		
		// Close the scanner
		keyboard.close();

	}

}
