// Author:	Matthew Morgan
// Date:	5 September 2016

import java.util.*;

public class AirWilmington {

	public static void main(String[] args) {

		// Variable declaration
		int lbOnBoard, lbAdded, lbUsedTakeOff, lbUsedLanding, lbPerMin;
		int lbRemain, timeMin, timeHour;
		Scanner keyboard = new Scanner(System.in);
		
		// Print instructions to the screen
		System.out.println("Air Wilmington Plane Flight Estimate");
		System.out.println("---------------------------------------------------");
		System.out.println("Estimate flight time based on fuel levels remaining");
		System.out.println("---------------------------------------------------");
		
		// Get user input for on-board and added fuel
		System.out.print("Enter pounds of fuel on board: ");
		lbOnBoard = keyboard.nextInt();
		System.out.print("Enter pounds added at station: ");
		lbAdded = keyboard.nextInt();
		
		// Get user input for fuel used
		System.out.print("Enter pounds used on take off: ");
		lbUsedTakeOff = keyboard.nextInt();
		System.out.print("Enter pounds used on landing: ");
		lbUsedLanding = keyboard.nextInt();
		System.out.print("Enter pounds used per minute in flight: ");
		lbPerMin = keyboard.nextInt();
		
		// Calculate remaining flight time
		lbRemain = (lbOnBoard + lbAdded) - (lbUsedTakeOff + lbUsedLanding);
		timeHour = (lbRemain / lbPerMin) / 60;
		timeMin = (lbRemain / lbPerMin) % 60;
		
		// Print result to screen
		System.out.println("---------------------------------------------------");
		System.out.println("Estimated Flight Time: " + timeHour + " hour(s), " + timeMin + " minute(s)");
		
		// Close scanner
		keyboard.close();

	}

}
