package assignment3.calculator;

import java.util.Scanner;

public class Q13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();

		Calculator.solve(replaceAllSpaces(expression));
		scanner.close();
	}	
	public static String replaceAllSpaces(String exp) {
		String expr =exp.replace(" ", "");
		return expr;
	}
}