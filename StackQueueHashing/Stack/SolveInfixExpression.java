package com.metacube.StackQueueHashing.Stack;

import java.util.*;

public class SolveInfixExpression {
	
	/*
	 * evaluating infix expression
	 * @param expression which needs to be evaluated
	 * @return evaluated value of type Integer
	 */
	public static Integer evaluateString (String expression) {
		
		// split expression with white space
		String expressionTerms[] = expression.split(" ");
		
		// create a stack for storing operands
		Stack<Integer> operands = new Stack<Integer>();
		
		//creates a stack for storing operators
		Stack<String> operators = new Stack<String>();
		
		// get the length of terms in expression
		int length = expressionTerms.length;
		
		// iterate through terms in expression
		for (int termIndex = 0; termIndex < length; termIndex++) {
			try {
				
				// expecting first  term as operand of type Integer
				Integer number = Integer.parseInt(expressionTerms[termIndex]);
				
				// adding to operand stack
				operands.push(number);
			} catch (Exception ex) {
				
				// checking for opening curly bracket
				if (expressionTerms[termIndex].equalsIgnoreCase("(")) {
					
					// adding to operator stack
					operators.push(expressionTerms[termIndex]);
				} else if (expressionTerms[termIndex].equalsIgnoreCase(")")) {
					
					// if closing curly bracket is found then evaluate the operator with top 2 operands and store them back
					while (!operators.getTop().equalsIgnoreCase("(")) {
						Integer evaluatedValue = evaluate (operands.pop(), operands.pop(), operators.pop());
						operands.push(evaluatedValue);
					}
					operators.pop();
				} else {
					
					// iterate through all operators until we get the next highest precedence operator
					while (!operators.isEmpty() && checkPrecedence(expressionTerms[termIndex], operators.getTop()) && !operands.isEmpty()) {
						Integer evaluatedValue = evaluate (operands.pop(), operands.pop(), operators.pop());
						operands.push(evaluatedValue);
					}
					operators.push(expressionTerms[termIndex]);
				}
			}
		}
		
		// if their remains some operators then evaluates them and add them
		while (!operators.isEmpty()) {
			Integer evaluatedValue = evaluate (operands.pop(), operands.pop(), operators.pop());
			operands.push (evaluatedValue);
		}
		return operands.pop();
	}
	
	/*
	 * Used to check the precedence of 2 operators
	 * @param operator1
	 * @param operator2
	 * @return true if first one is of higher precedence else false
	 */
	private static boolean checkPrecedence (String operator1, String operator2) {
		
		// creates a list of arithmetic operators
		List<String> arithmeticOperators = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
		
		// creates a list of relational operators
		List<String> relationalOperators = new ArrayList<String>(Arrays.asList("==", "!=", ">", "<", "<=", ">="));
		
		// creates a list of conditional operators
		List<String> conditionalOperators = new ArrayList<String>(Arrays.asList("&&", "||", "!"));
		
		if (operator2.equalsIgnoreCase("(") || operator2.equalsIgnoreCase(")")) {
			return false;
		}
		if (arithmeticOperators.contains(operator1)) {
			if (relationalOperators.contains(operator2) || conditionalOperators.contains(operator2)) {
				return false;
			} else {
				if ((operator1.equals("*") || operator1.equals("/")) && operator2.equals("+") || operator2.equals("-")) {
					return false;
				} else {
					return true;
				}
			}
		} else if (relationalOperators.contains(operator1)) {
			if (arithmeticOperators.contains(operator2)) {
				return true;
			} else if (conditionalOperators.contains(operator2)) {
				return false;
			} else {
				if ((operator1.equalsIgnoreCase("<") || operator1.equalsIgnoreCase("<=") || operator1.equalsIgnoreCase(">") || operator1.equalsIgnoreCase(">=")) &&
					(operator2.equalsIgnoreCase("==") || operator2.equalsIgnoreCase("!="))) {
					
						return false;
				} else {
					return true;
				}
			}
		} else {
			if (conditionalOperators.contains(operator2)) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	/*
	 * Evaluating a small expression
	 * @param number2
	 * @param number1
	 * @param operator
	 * @return evaluated value as Integer
	 */
	private static int evaluate (int number2, int number1, String operator) {
		if (operator.equalsIgnoreCase("+")) {
			return number1 + number2;
		} else if (operator.equalsIgnoreCase("-")) {
			return number1 - number2;
		} else if (operator.equalsIgnoreCase("*")) {
			return number1 * number2;
		} else if (operator.equalsIgnoreCase("/")) {
			return number1 / number2;
		} else if (operator.equalsIgnoreCase(">")) {
			return number1 > number2 ? 1 : 2;
		} else if (operator.equalsIgnoreCase("<")) {
			return number1 < number2 ? 1 : 2;
		} else if (operator.equalsIgnoreCase("==")) {
			return number1 == number2 ? 1 : 2;
		} else if (operator.equalsIgnoreCase("!=")) {
			return number1 != number2 ? 1 : 2;
		} else if (operator.equalsIgnoreCase("&&")) {
			return (number1 != 0 && number2 != 0) ? 1 : 2;
		} else if (operator.equalsIgnoreCase("||")) {
			return (number1 != 0 && number2 != 0) ? 1 : 2;
		}
		return 0;
	}
	
	public static void main (String args[]) {
		System.out.println(SolveInfixExpression.evaluateString("3 / 3 * ( 5 * 2 )"));
	}
	
}
