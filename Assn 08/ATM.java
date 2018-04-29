/*
 * Author:	Matthew Morgan
 * Date:	4 November 2016
 * This program simulates an ATM, allowing a user to sign in and manipulate
 * their account (i.e. their balance).
 */

import java.util.*;

public class ATM {

	// Public variables
	public static Scanner keyboard;

	public static void main(String[] args) {

		// Variable declaration
		keyboard = new Scanner(System.in);
		int loginAttempts = 0;
		double userBal;
		boolean userFinished = false;
		String userLogin = "", userPass = "", userBalStr;
		
		// Display welcome message
		System.out.println("----------------------------------");
		System.out.println("     Welcome to the MNM ATM!");
		
		while(loginAttempts < 3 && !userFinished) {
			// Display instruction
			System.out.println("----------------------------------");
			System.out.println("  Please enter user credentials.");
			System.out.println("----------------------------------");
			
			// Get user input
			System.out.print("Account: ");
			userLogin = keyboard.next();
			System.out.print("Password: ");
			userPass = keyboard.next();
			
			// Display menu if account information is correct
			userBalStr = checkID(userLogin, userPass);
			if (!userBalStr.equals("error")) {
				// Convert balance to double; display login success message
				userBal = Double.parseDouble(userBalStr);
				System.out.println("----------------------------------");
				System.out.println("         Login successful");
				
				// Loop user ATM operation until user logs out
				while (!userFinished)
					switch(menu()) {
						// Display balance
						case 1: displayBalance(userBal); break;
						// Log out
						case 4: userFinished = true; break;
						// Deposit
						case 2:
							// Print query
							System.out.println("----------------------------------");
							System.out.println("    How much will you deposit?");
							System.out.println("----------------------------------");
							System.out.print("Amount: $");
							userBal = deposit(userBal, keyboard.nextDouble());
							break;
						// Withdraw
						case 3:
							// Print query
							System.out.println("----------------------------------");
							System.out.println("   How much will you withdraw?");
							System.out.println("----------------------------------");
							System.out.print("Amount: $");
							userBal = withdraw(userBal, keyboard.nextDouble());
							break;
					}
				
				// Display logout message
				System.out.println("----------------------------------");
				System.out.println("      Logout was successful!");
				System.out.println(" Thank you for using the MNM ATM!");
				System.out.println("----------------------------------");
			}
			else {
				// Display error message (invalid account information)
				loginAttempts++;
				System.out.println("----------------------------------");
				System.out.println("   Account or password invalid!");
			}
		}
		
		// Display error message (max attempts)
		if (loginAttempts == 3) {
			System.out.println("----------------------------------");
			System.out.println("  Maximum login attempts reached");
			System.out.println("----------------------------------");
		}

		// Close the keyboard
		keyboard.close();
		
	}
	
	/**
	 * Adds a deposit to the current account balance
	 * @param accBal The current account balance
	 * @param deposit The amount to be deposited
	 * @return The new account balance with the deposit included
	 */
	public static double deposit(double accBal, double deposit) {
		
		return accBal+deposit;
		
	}
	
	/**
	 * Determines if an amount can be withdrawn from the current balance
	 * @param accBal The current account balance
	 * @param withdraw The amount to be withdrawn
	 * @return If the withdrawal amount exists, the account balance
	 * with the withdrawal amount deducted; elsewise, the current account
	 * balance
	 */
	public static double withdraw(double accBal, double withdraw) {
		
		// Check if withdrawal amount is greater than the current account balance
		if (withdraw <= accBal)
			if (withdraw < 0) {
				// Error message (withdrawn amount is negative)
				System.out.println("----------------------------------");
				System.out.println("Cannot withdraw a negative amount!");
				return accBal;
			}
			else
				return accBal-withdraw;
		else {
			// Error message (Not enough funds)
			System.out.println("----------------------------------");
			System.out.println(" Your account doesn't have enough");
			System.out.println("  funds to withdraw that amount!");
			return accBal;
		}
		
	}
	
	/**
	 * Displays the current account balance, accBal
	 * @param accBal Current balance for the account
	 */
	public static void displayBalance(double accBal) {

		// Print account balance to screen
		System.out.println("----------------------------------");
		System.out.printf("Current balance: $%.2f.%n", accBal);
		
	}
	
	/**
	 * Displays ATM menu and retrieves selection from the user about what
	 * they would like to do before validating the selection.
	 * @return If the user's menu selection is valid, returns the selection
	 * made by the user.
	 */
	public static int menu() {
		
		// Variable declaration
		int userChoice = 0;
		
		// Menu display loop: display menu and show error until appropriate
		// user selection is made
		while(userChoice < 1 || userChoice > 4) {
			// Display menu
			System.out.println("----------------------------------");
			System.out.println(" What would you like to do today?");
			System.out.println("  1. View Balance    3. Withdraw");
			System.out.println("  2. Deposit         4. Logout");
			System.out.println("----------------------------------");
			System.out.print("Your selection: ");
			
			// Get user choice
			userChoice = keyboard.nextInt();
			
			// Display error if invalid choice
			if (userChoice < 1 || userChoice > 4) {
				System.out.println("----------------------------------");
				System.out.println("        Selection invalid!");
			}
		}
		
		return userChoice;
		
	}
	
	/**
	 * Determines if acctNum is a valid account number and pwd is the
	 * correct password for the account.
	 * @param acctNum The account number to be tested
	 * @param pwd The possible password for the account
	 * @return If the account information is valid, returns the account balance
	 * as a string. If the account information is invalid, returns the string "error".
	 */
	public static String checkID(String acctNum, String pwd) {
		
		String result = "error";
		
		// Strings a, b, and c contain the valid account numbers and passwords.
		// For each string, the account number is listed first, followed by
		// a space, followed by the password for the account, followed by a space,
		// followed by the current balance.
		String a = "44567-5 mypassword 520.36";
		String b = "1234567-6 anotherpassword 48.20";
		String c = "4321-0 betterpassword 96.74";
		
		// Check validity of user account and passphrase
		if (acctNum.equals(a.substring(0,  a.indexOf(" "))) && a.substring(a.indexOf(" ")+1, a.lastIndexOf(" ")).equals(pwd)) {
			// Account 'a'
			result = a.substring(a.lastIndexOf(" ")+1);
		}
		else if (acctNum.equals(b.substring(0,  b.indexOf(" "))) && b.substring(b.indexOf(" ")+1, b.lastIndexOf(" ")).equals(pwd)) {
			// Account 'b'
			result = b.substring(b.lastIndexOf(" ")+1);
		}
		else if (acctNum.equals(c.substring(0,  c.indexOf(" "))) && c.substring(c.indexOf(" ")+1, c.lastIndexOf(" ")).equals(pwd)) {
			// Account 'c'
			result = c.substring(c.lastIndexOf(" ")+1);
		}

		return result;
		
	}
	

}