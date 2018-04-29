// Author:	Matthew Morgan
// Date:	17 October 2016
// Purpose: This program simulates a game of rock, paper, scissors where the
// user enters "rock," "paper," or "scissors" to play against a computerized
// opponent

import java.util.*;

public class PRS {
	
	// Constant declaration
	public static final int ROUND_WIN_USER = 1; // User wins round
	public static final int ROUND_WIN_COMP = 2; // Computer wins round
	public static final int ROUND_WIN_TIED = 3; // Round is tied

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		boolean gameCanStop = false;
		int ttlRounds=0, ttlWinUser=0, ttlWinPC=0, ttlWinTie=0;

		// Print title; get user input for instruction display
		System.out.println("Rock, Paper, Scissors!");
		System.out.println("--------------------------------");
		System.out.print("Display instructions? Input: ");
		if (keyboard.next().toLowerCase().equals("y")) {
			// Display instructions if option was "yes"
			System.out.println("--------------------------------");
			instructions();
		}
		
		// Game loop: stops when the user enters "no" after any round
		// Each iteration is a full round of the game
		while (!gameCanStop) {
			// Print round header to the screen
			System.out.println("--------------------------------");
			System.out.println("Round " + (ttlRounds+1));
			System.out.println("--------------------------------");
			
			// Round execution and result
			ttlRounds++;
			switch(playGame(keyboard)) {
				case ROUND_WIN_USER: System.out.println("You win the round!"); ttlWinUser++; break;
				case ROUND_WIN_COMP: System.out.println("The computer wins!"); ttlWinPC++; break;
				case ROUND_WIN_TIED: System.out.println("The round is tied!"); ttlWinTie++; break;
			}
			
			// Ask user if they want to play another round
			System.out.println("--------------------------------");
			System.out.print("Would you like to play again?\nInput: ");
			if (keyboard.next().toLowerCase().equals("n")) {
				// Game can stop; user is not continuing to next round
				gameCanStop = true;
			}
		}
		
		// Print results for whole game to screen
		System.out.println("--------------------------------");
		System.out.println("Results of Game:");
		System.out.println("--------------------------------");
		System.out.printf("Total rounds played: %4d", ttlRounds);
		System.out.printf("\nNum. user victories: %4d", ttlWinUser);
		System.out.printf("\nNumber PC victories: %4d", ttlWinPC);
		System.out.printf("\nTotal stalemates   : %4d", ttlWinTie);
		System.out.println("\n--------------------------------");
		System.out.println("Thank you for playing!");
		
		// Close the keyboard
		keyboard.close();

	}
	
	/**
	 * Prints a set of instructions to the screen about how to play the game of
	 * rock, paper, or scissors
	 */
	public static void instructions() {
		
		// Print basic instructions
		System.out.println("Welcome to rock, paper, scissors, a simple yet fun game.");
		System.out.println("The rule is simple: You select any of the three options by typing one in.");
		System.out.println("After you make your selection, your opponent also makes their choice.");
		System.out.println("The winner is then determined based on the following:"+"\n");
		
		// Print what beats what in RPS
		System.out.println("Rock crushes scissors. (Rock wins)");
		System.out.println("Scissors cut paper.    (Scissors win)");
		System.out.println("Paper covers rock.     (Paper wins)");
		System.out.println("If both players make the same choice, the game is tied.");
		
	}
	
	/**
	 * This function executes a single round of the rock, paper, scissors game. A
	 * singular round consists of getting user input, choosing computer input, and
	 * returning a result that will be used to display a victory message later.
	 * 
	 * @param tmp The scanner to be utilized for receiving user input
	 * @return Returns an integer discerning either user/computer victory or a tie
	 */
	public static int playGame(Scanner tmp) {
		
		// Variable declaration
		String userInput, compInput;
		int rndResult=0;
		
		// Get user input and PC choice
		System.out.print("Type your choice: ");
		userInput = tmp.next().toLowerCase();
		compInput = computerChoose();
		System.out.println("     You chose:   " + userInput);
		System.out.println("Opponent chose:   " + compInput);
		
		// Process user input against PC choice
		if (userInput.equals(compInput)) {
			// Return result as a tie
			rndResult = ROUND_WIN_TIED;
		}
		else
			switch(compInput) {
				// Computer selected paper
				case "paper":
					if (userInput.equals("rock"))
						rndResult = ROUND_WIN_COMP;
					else
						rndResult = ROUND_WIN_USER;
					break;
				// Computer selected rock
				case "rock":
					if (userInput.equals("scissors"))
						rndResult = ROUND_WIN_COMP;
					else
						rndResult = ROUND_WIN_USER;
					break;
				// Computer selected scissors
				case "scissors":
					if (userInput.equals("paper"))
						rndResult = ROUND_WIN_COMP;
					else
						rndResult = ROUND_WIN_USER;
					break;
			}
		
		// Return result of round
		return rndResult;
		
	}
	
	/**
	 * Randomly generates a selection for the computerized opponent for the
	 * current round of rock, paper, scissors.
	 * 
	 * @return Returns one of the three selections, as a string, for PC input
	 */
	public static String computerChoose() {
		
		// Variable declaration
	    Random generator = new Random();
	    String [] answer = new String[3];
	    answer[0] = "paper";
	    answer[1] = "rock";
	    answer[2] = "scissors";
		
		// Generate and return a random choice for the computer
	    return answer[generator.nextInt(3)];
		
	}

}
