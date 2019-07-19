package org.tektutor.tobedeletedrpncalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RPNCalculatorTest {

	@Test
	public void rpnSimpleAdditionTest() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.evaluate("10.0 20.0 +");
		double expectedResult = 30.0;
		assertEquals(expectedResult, actualResult, 0.01);
		
		actualResult = rpnCalculator.evaluate("30.0 20.0 +");
		expectedResult = 50.0;
		assertEquals(expectedResult, actualResult, 0.01);
	}
	
	@Test
	public void rpnSimpleSubtractionTest() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.evaluate("20.0 10.0 -");
		double expectedResult = 10.0;
		assertEquals(expectedResult, actualResult, 0.01);
		
		actualResult = rpnCalculator.evaluate("30.0 20.0 -");
		expectedResult = 10.0;
		assertEquals(expectedResult, actualResult, 0.01);
	}
	
	@Test
	public void rpnSimpleMultiplicationTest() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.evaluate("20.0 10.0 *");
		double expectedResult = 200.0;
		assertEquals(expectedResult, actualResult, 0.01);
		
		actualResult = rpnCalculator.evaluate("30.0 20.0 *");
		expectedResult = 600.0;
		assertEquals(expectedResult, actualResult, 0.01);
	}
	
	@Test
	public void rpnSimpleDivisionTest() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.evaluate("20.0 10.0 /");
		double expectedResult = 2.0;
		assertEquals(expectedResult, actualResult, 0.01);
		
		actualResult = rpnCalculator.evaluate("800.0 20.0 /");
		expectedResult = 40.0;
		assertEquals(expectedResult, actualResult, 0.01);
	}
	
	@Test
	public void testComplexRPNMathExpression() {
		RPNCalculator rpnCalculator = new RPNCalculator();
		double actualResult = rpnCalculator.evaluate("10 20 + 20 30 + + 4 -");
		double expectedResult = 76.0;
		assertEquals(expectedResult, actualResult, 0.01);
	}
}
