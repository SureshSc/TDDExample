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
}
