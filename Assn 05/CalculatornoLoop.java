// Author:	Matthew Morgan
// Date:	28 September 2016
// Purpose: This program obtains two integers and an operator from the user and
// calculates the result dependent on the operator.

import java.util.*;

public class CalculatornoLoop {
	
	public static void main(String[] args) {
		
		// Variable declaration
		Scanner keyboard = new Scanner(System.in);
		String input, result;
		int calcN1, calcN2, calcFin;
		char mathOp;
		
		// Print instructions to screen
		System.out.println("Basic Calculator:");
		System.out.println("Enter two integers and an operator.");
		System.out.println("I will calculate the result.");
		System.out.println("Example: 2 // 3");
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
		
		// Get user input
		calcN1 = keyboard.nextInt();
		input = keyboard.next();
		calcN2 = keyboard.nextInt();
		if (input.equals("//")) {
			// Division operator (integer)
			mathOp = '\\';
		}
		else {
			// Another operator
			mathOp = input.charAt(0);
		}
		
		// Divide by zero error check
		if ((mathOp == '\\' || mathOp == '/' || mathOp == '%') && (calcN2 == 0)) {
			result = "ERROR: Division by zero";
		}
		else {
			// Calculate based on operator
			switch(mathOp) {
				case '\\':
					// Division (integer treatment)
					calcFin = calcN1 / calcN2;
					result = calcN1 + " // " + calcN2 + " = " + calcFin;
					break;
				case '/':
					// Division (float treatment)
					result = calcN1 + " / " + calcN2 + " = " + ((float)calcN1 / (float)calcN2);
					break;
				case '%':
					// Modulus (remainder only)
					calcFin = calcN1 % calcN2;
					result = calcN1 + " % " + calcN2 + " = " + calcFin;
					break;
				case '+':
					// Addition
					calcFin = calcN1 + calcN2;
					result = calcN1 + " + " + calcN2 + " = " + calcFin;
					break;
				case '-':
					// Subtraction
					calcFin = calcN1 - calcN2;
					result = calcN1 + " - " + calcN2 + " = " + calcFin;
					break;
				case '*':
					// Multiplication
					calcFin = calcN1 * calcN2;
					result = calcN1 + " * " + calcN2 + " = " + calcFin;
					break;
				case '^':
					// Exponent
					calcFin = (int)Math.pow(calcN1, calcN2);
					result = calcN1 + " ^ " + calcN2 + " = " + calcFin;
					break;
				default:
					// Unrecognized operator
					result = "ERROR: No such operator exists";
					break;
			}
		}
		
		// Print result
		System.out.println(result);
		
		// Close keyboard
		keyboard.close();
		
	}

}