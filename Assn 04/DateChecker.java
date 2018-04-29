// Author:	Matthew Morgan
// Date:	20 September 2016

import java.util.*;

public class DateChecker {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		boolean chkFormatSlash, chkMonthRange, chkDayRange, chkYearLeap;
		int dateLength, dateUserD, dateUserM, dateUserY;
		String userInput, invalidReason = "";

		// Get user input
		System.out.print("Enter a date (mm/dd/yyyy): ");
		userInput = keyboard.nextLine();
		
		// FIRST CHECK: length
		dateLength = userInput.length();
		if (dateLength < 10) {
			// Rejection (length too short)
			invalidReason = "Too few characters in the date.";
		}
		else if (dateLength > 10) {
			// Rejection (length too great)
			invalidReason = "Too many characters in the date.";
		}
		else {
			// SECOND CHECK: location of slashes
			chkFormatSlash = ((userInput.charAt(2) == '/') && (userInput.charAt(5) == '/'));
			
			if (!chkFormatSlash) {
				// Rejection (formatting)
				invalidReason = "Incorrect format.";
			}
			else {
				// THIRD CHECK: month validity
				dateUserM = Integer.parseInt(userInput.substring(0, 2));
				chkMonthRange = ((dateUserM >= 1) && (dateUserM <= 12));
				
				if (!chkMonthRange) {
					// Rejection (month validity)
					invalidReason = "Month is not valid.";
				}
				else {
					// FOURTH CHECK: day validity
					dateUserD = Integer.parseInt(userInput.substring(3, 5));
					chkDayRange = (dateUserD >= 1);
					
					if ((dateUserM == 4) || (dateUserM == 6) || (dateUserM == 9) || (dateUserM == 11)) {
						// Month has 30 days
						chkDayRange = (chkDayRange && (dateUserD <= 30));
					}
					else if (dateUserM != 2) {
						// Month is not February (31 days)
						chkDayRange = (chkDayRange && (dateUserD <= 31));
					}
					else {
						// Month is February
						boolean chkDiv4, chkDiv100, chkDiv400;
						dateUserY = Integer.parseInt(userInput.substring(6));
						chkDiv4 = ((dateUserY % 4) == 0);     // Year is divisible by 4
						chkDiv100 = ((dateUserY % 100) == 0); // Year is divisible by 100
						chkDiv400 = ((dateUserY % 400) == 0); // Year is divisible by 400
						chkYearLeap = ((chkDiv4 && !chkDiv100) || (chkDiv100 && chkDiv400));
						
						// Check day range
						if (chkYearLeap) {
							chkDayRange = (chkDayRange && (dateUserD <= 29));
						}
						else {
							chkDayRange = (chkDayRange && (dateUserD <= 28));
						}
					}
					
					if (!chkDayRange) {
						// Rejection (day validity)
						invalidReason = "Day is not valid.";
					}
				}
			}
		}
		
		// Print rejection or acceptance statement
		if (invalidReason.equals("")) {
			// Acceptance statement
			System.out.println("\nValid date.");
		}
		else {
			// Rejection statement (with reason)
			System.out.println("\nNot a valid date.\n" + invalidReason);
		}
		
		// Close the scanner
		keyboard.close();
		
	}
}