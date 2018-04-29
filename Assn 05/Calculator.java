// Author:	Matthew Morgan
// Date:	  27 September 2016
// Purpose:
// This program obtains two integers and an operator from the
// user and calculates the result dependent on the operator.

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String userInput, result = "";
		char mathOp = 'n';
		int intMathN1 = 0, intMathN2 = 0, intMathFin;
		
		// Print instructions to screen
		System.out.println("Basic Calculator:");
		System.out.println("Enter two integers and an operator.");
		System.out.println("I will calculate the result.");
		System.out.println("-------------------------------");
		System.out.println("List of Operators:"
				+ "\n  +  Addition"
				+ "\n  -  Subtraction"
				+ "\n  *  Multiplication"
				+ "\n  /  Normal Division"
				+ "\n  // Division (integer only)"
				+ "\n  %  Division (remainder only)"
				+ "\n  ^  Exponent (a^b)");
		System.out.println("-------------------------------");
		System.out.print("Enter your equation: ");
		
		// Retrieve user input
		userInput = keyboard.nextLine();
		userInput = userInput.replaceAll(" ",  "");
		userInput = userInput.replaceAll("\t", "");
		System.out.println("-------------------------------");
		
		// Loop through all characters in user input
		// The loop ends early when an operator is found
		for(int i=0; i<userInput.length(); i++) {
			if (i == userInput.length()-1) {
				// Error: Only 1 integer (END OF STRING REACHED)
				result = "ERROR: Only one integer entered";
			}
			else {
				if ((userInput.charAt(i) < '0') || (userInput.charAt(i) > '9')) {
					// Current index is NOT a number [0-9]
					if (i == 0) {
						// Current index is index 0 (START OF STRING)
						if (userInput.charAt(i) != '-') {
							// Negative operator not detected; error
							result = "ERROR: Unknown character or only 1 integer entered";
						}
						else {
							// Negative operator for integer; continue loop
							continue;
						}
					}
					else {
						// Current index is NOT index 0 (START OF STRING)
						if (i+1 >= userInput.length()) {
							// Next index is greater than length; error
							result = "ERROR: Only one integer entered";
							break;
						}
						else {
							// Next index is not larger than length
							if (i+2 >= userInput.length() && userInput.charAt(i+1) == '/') {
								// Index after next is larger or equivalent to length and
								// a second backslash is detected
								result = "ERROR: Only one integer entered";
								break;
							}
						}
						
						// MAJOR STEP : RECOGNITION OF OPERATORS
						if (userInput.charAt(i) == '/') {
							// Division operator detected
							if (userInput.charAt(i+1) == '/') {
								// Division operator (returns integer) detected
								mathOp = '\\';
								intMathN1 = Integer.parseInt(userInput.substring(0, i));
								intMathN2 = Integer.parseInt(userInput.substring(i+2));
							}
							else if ((userInput.charAt(i+1) >= '0'
									&& userInput.charAt(i+1) <= '9')
									|| userInput.charAt(i+1) == '-') {
								// Division operator (returns decimal)
								// Recognized if [0-9] or '-' is present in next character
								mathOp = '/';
								intMathN1 = Integer.parseInt(userInput.substring(0, i));
								intMathN2 = Integer.parseInt(userInput.substring(i+1));
							}
							else {
								// Unrecognized division operator
								mathOp = 'n';
							}
						}
						else {
							// Operator other than division is detected
							mathOp = userInput.charAt(i);
							intMathN1 = Integer.parseInt(userInput.substring(0, i));
							intMathN2 = Integer.parseInt(userInput.substring(i+1));
						}
						
						// CHECK: Division by zero error
						if (mathOp == '\\' || mathOp == '/' || mathOp == '%') {
							if (intMathN2==0) { result = "ERROR: Division by zero"; break; }
						}
											
						switch(mathOp) {
							case '\\':
								// Division (integer treatment)
								intMathFin = intMathN1 / intMathN2;
								result = intMathN1 + " // " + intMathN2 + " = " + intMathFin;
								break;
							case '/':
								// Division (float treatment)
								result = intMathN1 + " / " + intMathN2 + " = " +
										((float)intMathN1 / (float)intMathN2);
								break;
							case '%':
								// Modulus (remainder only)
								intMathFin = intMathN1 % intMathN2;
								result = intMathN1 + " % " + intMathN2 + " = " + intMathFin;
								break;
							case '+':
								// Addition
								intMathFin = intMathN1 + intMathN2;
								result = intMathN1 + " + " + intMathN2 + " = " + intMathFin;
								break;
							case '-':
								// Subtraction
								intMathFin = intMathN1 - intMathN2;
								result = intMathN1 + " - " + intMathN2 + " = " + intMathFin;
								break;
							case '*':
								// Multiplication
								intMathFin = intMathN1 * intMathN2;
								result = intMathN1 + " * " + intMathN2 + " = " + intMathFin;
								break;
							case '^':
								// Exponent
								intMathFin = (int)Math.pow(intMathN1, intMathN2);
								result = intMathN1 + " ^ " + intMathN2 + " = " + intMathFin;
								break;
							default:
								// 'n'
								result = "ERROR: No such operator exists";
								break;
						}
					}
				
					// Break from loop
					break;
				}
			}
		}
		
		// Print result (error or calculation)
		System.out.println(result);
		
		// Close keyboard
		keyboard.close();
	}
	
}
