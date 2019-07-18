package org.tektutor.tobedeletedrpncalculator;

import java.util.HashMap;

import org.tektutor.tobedeletedrpncalculator.IMathOperation;

public class MathFactory {
	
	private static HashMap<String, String> classNameMap;

	static {
		classNameMap = new HashMap<String, String>();
		classNameMap.put("+", "org.tektutor.tobedeletedrpncalculator.Addition");
		classNameMap.put("-", "org.tektutor.tobedeletedrpncalculator.Subtraction");
		classNameMap.put("*", "org.tektutor.tobedeletedrpncalculator.Multiplication");
		classNameMap.put("/", "org.tektutor.tobedeletedrpncalculator.Division");
	}
	public static IMathOperation getObject(String mathOperator) {
		IMathOperation mathOperation = null;
		String className = classNameMap.get( mathOperator );
		try {
			mathOperation = (IMathOperation)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mathOperation;
	}

}
