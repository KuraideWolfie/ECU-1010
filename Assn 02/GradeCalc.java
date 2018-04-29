// Author:	Matthew Morgan
// Date:	5 September 2016

import java.util.*;

public class GradeCalc {

	// Constant declaration
	public static final double GRD_TESTAVG = 0.3; //Test average
	public static final double GRD_ASSIGNS = 0.5; //Assignment average
	public static final double GRD_FINALEX = 0.2; //Final exam grade
	
	public static void main(String[] args) {
		
		// Variable declaration
		double grdTest, grdAssign, grdExam, grdFinal;
		Scanner keyboard = new Scanner(System.in);
		
		// Print header to screen
		System.out.println("     CSCI-1010 Final Grade Calculator");
		System.out.println("------------------------------------------");
		System.out.println("Final Grade Composition:");
		System.out.println("Testing Average: " + (int)(GRD_TESTAVG * 100) + "%");
		System.out.println("Homework Average: " + (int)(GRD_ASSIGNS * 100) + "%");
		System.out.println("Final Exam Grade: " + (int)(GRD_FINALEX * 100) + "%");
		System.out.println("------------------------------------------");
		
		// Get user input for test average
		System.out.print("Enter student's test average: ");
		grdTest = keyboard.nextDouble();
		
		// Get user input for assignment average
		System.out.print("Enter student's assignment average: ");
		grdAssign = keyboard.nextDouble();
		
		// Get user input for final exam
		System.out.print("Enter student's final exam grade: ");
		grdExam = keyboard.nextDouble();
		
		// Calculate final grade
		grdFinal =
				(grdTest * GRD_TESTAVG) +
				(grdAssign * GRD_ASSIGNS) +
				(grdExam * GRD_FINALEX);
		
		// Print final grade to screen
		System.out.println("------------------------------------------");
		System.out.println("Student's Final Grade: " + grdFinal);
		
		// Close scanner
		keyboard.close();
		
	}

}
