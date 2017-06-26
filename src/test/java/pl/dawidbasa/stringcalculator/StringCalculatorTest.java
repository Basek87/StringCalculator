package pl.dawidbasa.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	
	StringCalculator calculator = new StringCalculator();
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void emptyStringShouldReturnZero(){
		assertEquals(calculator.calculate(""), 0);
	}
	
	@Test
	public void singleStringShouldReturnSameValue(){
		assertEquals(calculator.calculate("1"), 1);
		assertEquals(calculator.calculate("11"), 11);
	}
	
	@Test
	public void commaSeparatedStringsShouldReturnSum(){
		assertEquals(calculator.calculate("1,2"), 3);
		assertEquals(calculator.calculate("21,12"), 33);
	}
	
	@Test
	public void multiCommasSeparatedStringsShouldReturnSum(){
		assertEquals(calculator.calculate("1,1,1"), 3);
		assertEquals(calculator.calculate("1,2,3,4"), 10);
	}
	
	@Test
	public void multiCommaAndNewLinesSeparatedStringsShouldReturnSum(){
		assertEquals(calculator.calculate("1\n1"), 2);
		assertEquals(calculator.calculate("1\n2,3"), 6);	
	}
	
	@Test
	public void specifedDelimitersShouldReturnSum(){
		assertEquals(calculator.calculate("//;\n1;2"), 3);
	}
	
	@Test
	public void negativeNumbersShouldReturnIllegalArgumentException(){
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negatives not allowed -3");;
		calculator.calculate("-3");
	}
	
	@Test
	public void groupOfNegativeNumbersShouldReturnIllegalArgumentException(){
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negatives not allowed -3,-5,-4");;
		calculator.calculate("-3,-5,-4,2,5,6");
	}
	
	@Test
	public void numbersBiggerThan1000ShouldBeIgnored(){
		assertEquals(calculator.calculate("1001,10004"), 5);
	}
}
 