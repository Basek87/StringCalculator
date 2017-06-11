package pl.dawidbasa.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void emptyStringShouldReturnZero(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(calculator.calculate(""), 0);
	}
	
	@Test
	public void singleStringShouldReturnSameValue(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(calculator.calculate("1"), 1);
		assertEquals(calculator.calculate("11"), 11);
	}
	
	@Test
	public void commaSeparatedStringsShouldReturnSum(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(calculator.calculate("1,2"), 3);
		assertEquals(calculator.calculate("21,12"), 33);
	}
	
	@Test
	public void multiCommasSeparatedStringsShouldReturnSum(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(calculator.calculate("1,1,1"), 3);
		assertEquals(calculator.calculate("1,2,3,4"), 10);
	}
	
	@Test
	public void multiCommaAndNewLinesSeparatedStringsShouldReturnSum(){
		StringCalculator calculator = new StringCalculator();
		assertEquals(calculator.calculate("1\n1"), 2);
		assertEquals(calculator.calculate("1\n2,3"), 6);
		
		
	}
}
 