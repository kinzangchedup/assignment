package assignment3.calculator;

public class Calculator {
	public static void solve( String expression) {
		 String bracket = "";
		 String divide = "";
		 String multiply = "";
		 String add = "";
		 String subtract = "";
		 bracket= divide= multiply = add = subtract = expression;
		 if(divide.contains("(")) {
			 bracket=divide= multiply = add = subtract = new Calculator().bracket(bracket);
			}
		 if(divide.contains("/")) {
			divide= multiply = add = subtract = new Calculator().divide(divide);
		}
		if (multiply.contains("*")) {
			divide= multiply = add = subtract = new Calculator().multiply(multiply);
		}
		if (expression.contains("+")) {
			divide= multiply = add = subtract = new Calculator().add(add);
		}
		if (expression.contains("-")) {
			divide= multiply = add = subtract=new Calculator().subtract(subtract);
		}
		System.out.println("Answer to an expression: "+expression+"\n"+subtract);
	}


	private String bracket(String bracket) {
		String expression = bracket;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='(') {
				char operator=0;
				for (int j = (i + 1); j < expression.length(); j++) {
					char t = expression.charAt(j);
					if (t == '+') {
						operator=t;
						expression=expression.replace("("+leftValue(j, expression) +operator+ rightValue(j, expression)+")",
								String.valueOf(Integer.parseInt(leftValue(j, expression))
										+ Integer.parseInt(rightValue(j, expression))));
						break;
					}
					if (t == '-') {
						operator=t;
						expression=expression.replace("("+leftValue(j, expression) +operator+ rightValue(j, expression)+")",
								String.valueOf(Integer.parseInt(leftValue(j, expression))
										- Integer.parseInt(rightValue(j, expression))));
						break;
					}
					if (t == '/') {
						operator=t;
						expression=expression.replace("("+leftValue(j, expression) +operator+ rightValue(j, expression)+")",
								String.valueOf(Integer.parseInt(leftValue(j, expression))
										/ Integer.parseInt(rightValue(j, expression))));
						break;
					}
					if (t == '*') {
						operator=t;
						expression=expression.replace("("+leftValue(j, expression) +operator+ rightValue(j, expression)+")",
								String.valueOf(Integer.parseInt(leftValue(j, expression))
										* Integer.parseInt(rightValue(j, expression))));
						break;
					}
				}			
			}
		}
		return expression;
	}


	private String subtract(String s) {
		String expression = s;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='-') {
				expression=expression.replace(leftValue(i, expression) + "-" + rightValue(i, expression),
				String.valueOf(Integer.parseInt(leftValue(i, expression))
				- Integer.parseInt(rightValue(i, expression))));
			}
		}
		return expression;
	}
	private String add(String s) {
		String expression = s;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='+') {	
				expression=expression.replace(leftValue(i, expression) + "+" + rightValue(i, expression),
				String.valueOf(Integer.parseInt(leftValue(i, expression))
				+ Integer.parseInt(rightValue(i, expression))));
			}
		}
		return expression;
	}

	private String multiply(String s) {
		String expression = s;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='*') {
				expression=expression.replace(leftValue(i, expression) + "*" + rightValue(i, expression),
							String.valueOf(Integer.parseInt(leftValue(i, expression))
									* Integer.parseInt(rightValue(i, expression))));
			}
		}
		return expression;
	}

	private String divide(String s) {
		String expression = s;
		//int count = 0;
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='/') {//24/2
				expression = expression.replace(leftValue(i, expression) + "/" + rightValue(i, expression),
						String.valueOf(Integer.parseInt(leftValue(i, expression))
								/ Integer.parseInt(rightValue(i, expression))));
			}
		}
		return expression;
	}// 13*5-20+2*12 // 
	
	public static String leftValue(int i, String expression) {// i =11=
		String lefValue = "";
		for (int j = (i - 1); j >= 0; j--) { 
			char t = expression.charAt(j);
			if (t == '+' || t == '*' || t == '-' || t == '/' || t == '(' || t == ')') {
				break;
			}
			lefValue = expression.charAt(j) + lefValue;// 24
		}
		return lefValue;
	}

	public static String rightValue(int i, String expression) { //12
		String rightValue = "";
		for (int j = (i + 1); j < expression.length(); j++) {
			char t = expression.charAt(j);
			if (t == '+' || t == '*' || t == '-' || t == '/'  || t == '(' || t == ')') {
				break;
			}
			rightValue = rightValue+expression.charAt(j); //2
		}
		return rightValue;
	}
}
