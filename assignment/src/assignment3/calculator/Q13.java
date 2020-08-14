package assignment3.calculator;

import java.util.Scanner;

public class Q13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		if(expression.contains(" ")) {
			System.out.println("White spaces not valid expression");
		}else {
			Calculator.solve(expression);
		}
		scanner.close();
	}	
}