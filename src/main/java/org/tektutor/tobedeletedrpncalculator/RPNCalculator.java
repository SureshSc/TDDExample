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
		
		IMathOperation mathOperation = null;
		for (String token : tokens) {
			if (isMathOperator(token)) {
				mathOperation = MathFactory.getObject(token);
				extractInputs();
				result = mathOperation.evaluate(firstNumber, secondNumber);
				numberStack.push(result);
			} else {
				numberStack.push(Double.parseDouble(token));
			}
		}
		
		return numberStack.pop();
	}

	private boolean isMathOperator(String token) {
		String mathOperator = "+-*/";
		return mathOperator.contains(token);
	}

	private void extractInputs() {
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
	}

}
