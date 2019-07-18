package org.tektutor.tobedeletedrpncalculator;

import java.util.Stack;

public class RPNCalculator {

	private Stack<Double> numberStack;
	private double firstNumber, secondNumber, result;
	
	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0;
	}
	
	public double evaluate(String rpnMathExpression) {
		// TODO Auto-generated method stub
		
		String[] tokens = rpnMathExpression.split(" ");
		
		for (String token : tokens) {
			if (token.equals("+")) {
				secondNumber = numberStack.pop();
				firstNumber = numberStack.pop();
				result = firstNumber + secondNumber;
				numberStack.push(result);
			} else if (token.equals("-"))  {
				secondNumber  = numberStack.pop();
				firstNumber = numberStack.pop();
				result = firstNumber - secondNumber;
				numberStack.push(result);
			} else {
				numberStack.push(Double.parseDouble(token));
			}
		}
		
		
		return numberStack.pop();
	}

}
