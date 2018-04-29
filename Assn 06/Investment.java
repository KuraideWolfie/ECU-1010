// Author:	Matthew Morgan
// Date:	3 October 2016
// Purpose:	This program calculates how many years a balance would take to
// double and displays this time to the user

import java.util.*;

public class Investment {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		int invTime;
		float invRate, invBalInit, invBalCur;
		invTime = 0;    // Investment time (in years)
		invBalInit = 0; // Initial investment amount
		invBalCur = 0;  // Current calculated balance
		invRate = 0;    // Investment rate (percentage)
		
		// Print instructions to screen; get user input
		System.out.println("Double the Investment Calculator");
		System.out.print("Enter initial balance (no commas)      : $");
		invBalInit = invBalCur = keyboard.nextFloat();
		System.out.print("Enter the interest rate (in percentage): ");
		invRate = (float)keyboard.nextInt() / 100;
		
		// Recalculate current balance until it's at least double the initial
		// Each recalculation increments the time (in years) by 1
		while((invBalCur / invBalInit) <= 2) {
			invBalCur += invBalCur * invRate;
			invTime++;
		}
		
		// Print result
		System.out.println("\nThe balance will double in " + invTime + " years");
		
		// Close the keyboard
		keyboard.close();
		
	}
	
}
