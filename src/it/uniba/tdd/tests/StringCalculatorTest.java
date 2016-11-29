package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniba.tdd.StringCalculator;
import it.uniba.tdd.StringCalculatorException;

public class StringCalculatorTest {
	
	StringCalculator stringCalculator;
	

	@Before
	public void initialize() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void addEmptyString() throws StringCalculatorException {
		int result = stringCalculator.add("");
		assertEquals(0, result);
	}
	
	@Test
	public void addOneCharacterString() throws StringCalculatorException{
		int result = stringCalculator.add("1");
		assertEquals(1, result);
	}
	
	@Test
	public void addTwoCharacterString() throws StringCalculatorException{
		int result = stringCalculator.add("1,2");
		assertEquals(3, result);
	}
	
	@Test
	public void addUnknowCharacterString() throws StringCalculatorException{
		int result = stringCalculator.add("1,2,3");
		assertEquals(6, result);
	}
	
	@Test
	public void addUnknowWithNewLineString() throws StringCalculatorException{
		int result = stringCalculator.add("1\n2,3");
		assertEquals(6, result);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addUnknowWithNewLineFinalString() throws StringCalculatorException{
		stringCalculator.add("1,\n");
		stringCalculator.add("1\n,");
	}
	
	
	@Test
	public void addCharacterWithNoDefaultDelimiter() throws StringCalculatorException{
		int result = stringCalculator.add("//;\n1;2");
		assertEquals(3, result);
	}
	
	
	
	
	
	

}
