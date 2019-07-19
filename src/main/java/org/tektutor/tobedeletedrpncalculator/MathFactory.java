package org.tektutor.tobedeletedrpncalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.tektutor.tobedeletedrpncalculator.IMathOperation;

public class MathFactory {
	
	private static HashMap<String, String> classNameMap;

	static {
		classNameMap = new HashMap<String, String>();
		
		try {
			FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			properties.forEach( (key, value) -> {
				classNameMap.put((String)key, (String)value);
			});
			
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		classNameMap.put("+", "org.tektutor.tobedeletedrpncalculator.Addition");
//		classNameMap.put("-", "org.tektutor.tobedeletedrpncalculator.Subtraction");
//		classNameMap.put("*", "org.tektutor.tobedeletedrpncalculator.Multiplication");
//		classNameMap.put("/", "org.tektutor.tobedeletedrpncalculator.Division");
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
