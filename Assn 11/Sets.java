// Author:	Matthew Morgan
// Date:	29 November 2016
// Purpose:	This program gets 20 unique integers for two different sets and
// calculates the intersection of the sets, the difference of set A from B,
// and the difference of set B from A.

import java.util.*;

public class Sets {

	// Constants
	public static final int MAXSIZE = 20;
	
	// Class variables
	public static Scanner keyboard;

	public static void main(String[] args) {

		// Variable declaration
		keyboard = new Scanner(System.in);
		int [] set01 = new int [MAXSIZE];
		int [] set02 = new int [MAXSIZE];
		int [] setResult = new int [MAXSIZE];
		int [] setSize = new int [3];
		String newSets = "";
		
		do {
			// Get first set's data
			System.out.println("-----------------------------------------------");
			System.out.println("Please enter up to "+MAXSIZE+" unique integers for set 1.");
			System.out.println("Cancel input with a negative integer.");
			System.out.print("Enter Integers: ");
			setSize[0] = getData(set01);
			System.out.println("-----------------------------------------------");
			
			// Get second set's data
			System.out.println("Please enter up to "+MAXSIZE+" unique integers for set 2.");
			System.out.print("Enter Integers: ");
			setSize[1] = getData(set02);
			System.out.println("-----------------------------------------------");
			
			// Sort the two sets
			sort(set01, setSize[0]);
			sort(set02, setSize[1]);
			
			// Calculate intersection and print to screen
			setSize[2] = intersection(set01, setSize[0], set02, setSize[1], setResult);
			System.out.print("The intersection of these sets is:     {");
			for(int i=0; i<setSize[2]; i++)
				System.out.print(setResult[i] + (i!=(setSize[2]-1) ? ", " : ""));
			System.out.println("}");
			
			// Calculate difference of the first set from the second and print to screen
			setSize[2] = difference(set01, setSize[0], set02, setSize[1], setResult);
			System.out.print("The difference of set 1 from set 2 is: {");
			for(int i=0; i<setSize[2]; i++)
				System.out.print(setResult[i] + (i!=(setSize[2]-1) ? ", " : ""));
			System.out.println("}");

			// Calculate difference of the second set from the first and print to screen
			setSize[2] = difference(set02, setSize[1], set01, setSize[0], setResult);
			System.out.print("The difference of set 2 from set 1 is: {");
			for(int i=0; i<setSize[2]; i++)
				System.out.print(setResult[i] + (i!=(setSize[2]-1) ? ", " : ""));
			System.out.println("}");

			// Repetition of operations prompt
			System.out.println("-----------------------------------------------");
			System.out.println("Would you like to try two new sets? (y/n)");
			System.out.print("Answer > ");
			newSets = keyboard.next();
		}
		while(newSets.toLowerCase().equals("y"));
		
		// Print conclusion message
		System.out.println("-----------------------------------------------");
		System.out.println("Thank you for using this program!");
		System.out.println("-----------------------------------------------");

		// Close the keyboard
		keyboard.close();

	}
	
	/**
	 * Obtains user input for a set
	 * @param set The set to place the data into
	 * @return The size of the set after input is finished
	 */
	public static int getData(int [] set) {
		
		// Variable declaration
		int arrSize = 0, tmpData;
		boolean loopEnd = false;
		
		// Loop keyboard input
		// Exits when a negative integer or maximum array size is reached
		do {
			tmpData = keyboard.nextInt();
			
			// Check if maximum set size reached
			// If not, check if set contains input already
			if (tmpData < 0 || arrSize == MAXSIZE-1)
				loopEnd = true;
			else if (!setContains(set, arrSize, tmpData)) {
				set[arrSize] = tmpData;
				arrSize++;
			}
		}
		while(!loopEnd);
		
		// Return size of array
		return arrSize;
		
	}
	
	/**
	 * Determines the intersection of two given sets
	 * @param setA The first set being intersected
	 * @param sizeA Size of the first set
	 * @param setB The second set being intersected
	 * @param sizeB Size of the second set
	 * @param resultSet The set to store the intersection's results in
	 * @return The number of entries in the result set
	 */
	public static int intersection(int [] setA, int sizeA, int [] setB,
			int sizeB, int [] resultSet)
	{
		
		// Variable declaration
		int resultSetSize = 0;
		
		// Create intersection set by checking if each element of A is
		// contained within set B as well
		for(int i=0; i<sizeA; i++)
			if (setContains(setB, sizeB, setA[i])) {
				resultSet[resultSetSize] = setA[i];
				resultSetSize++;
			}
		
		// Return result set size
		return resultSetSize;
		
	}

	/**
	 * Creates a set based on the difference of setA and setB
	 * @param setA The first set to check the difference of
	 * @param sizeA The size of the first set
	 * @param setB The second set to check setA against
	 * @param sizeB The size of the second set
	 * @param resultSet The set to contain all values of setA - setB
	 * @return The size of the array resultSet
	 */
	public static int difference(int [] setA, int sizeA, int [] setB,
			int sizeB, int [] resultSet)
	{
		
		// Variable declaration
		int resultSetSize = 0;

		// Loop to check the difference of elements of setA against setB
		for(int i=0; i<sizeA; i++)
			if (!setContains(setB, sizeB, setA[i])) {
				resultSet[resultSetSize] = setA[i];
				resultSetSize++;
			}
		
		// Return the size of resultSet
		return resultSetSize;
		
	}
	
	/**
	 * Determines if an integer set contains the specified value
	 * @param set The set to check the contents of against 'value'
	 * @param setSize The size of the set being checked
	 * @param value The value to check the set contains
	 * @return True or false based on if 'value' can be located in the set
	 */
	public static boolean setContains(int [] set, int setSize, int value) {
		
		// Variable declaration
		boolean result = false;
		
		// Loop content check
		// Flags "result" if the specified value is within the set
		for(int i=0; i<setSize; i++)
			if (set[i] == value)
				result = true;
		
		// Return result
		return result;
		
	}
	
	/**
	 * Sorts a specified set in ascending order
	 * @param nums The array to be sorted
	 * @param size The size of the array
	 */
	public static void sort(int [] nums, int size) {
		
		// Variable declaration
		int [] tmpSet = new int [MAXSIZE];
		int intsLargerThan = 0;
		
		// Duplicate set data into temporary array
		for(int i=0; i<size; i++)
			tmpSet[i] = nums[i];

		// Loop until all integers have been given a new index
		for(int i=0; i<size; i++) {
			// Determine how many ints in the set the current is greater than
			for(int ii=0; ii<size; ii++)
				if (tmpSet[i] > tmpSet[ii])
					intsLargerThan++;
			
			// Place integer at its new index and reset counter
			nums[intsLargerThan] = tmpSet[i];
			intsLargerThan = 0;
		}
		
	}
}
