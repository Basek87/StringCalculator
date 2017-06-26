/* tests passed */
// 1. Method adds strings (0,1,2, or more) if empty return 0
// 2. Allow the Add method to handle new lines between numbers (instead of
// commas).
// 3. Support different delimiters - example “//;\n1;2” should return three
// where the default delimiter
// 4.Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message	
// 5.Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

package pl.dawidbasa.stringcalculator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

	public String delimiter;
	public String numbers;

	public StringCalculator() {
	}

	public StringCalculator(String delimiter, String numbers) {
		super();
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	public int calculate(String input) {
		return checkInput(input).sum();
	}

	private int sum() {
		checkForNegativeNumbers();
		return getNumbers().sum();
	}

	private void checkForNegativeNumbers() {
		String negativeNumbers = getNumbers()
				.filter(n -> n < 0)
				.mapToObj(Integer::toString)
				.collect(Collectors.joining(","));
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed " + negativeNumbers);
		}
	}

	private IntStream getNumbers() {
		if (numbers.isEmpty()) {
			return IntStream.empty();
		}
		return Stream.of(numbers
				.split(delimiter))
				.mapToInt(Integer::parseInt)
				.map(n -> n % 1000);
	}

	private StringCalculator checkInput(String input) {
		if (input.startsWith("//")) {
			String[] parts = input.split("\n", 2);
			return new StringCalculator(parts[0].substring(2), parts[1]);
		} else {
			return new StringCalculator(",|\n", input);
		}
	}

}
