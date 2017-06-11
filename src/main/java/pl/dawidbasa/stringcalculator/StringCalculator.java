package pl.dawidbasa.stringcalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

	/* tests passed */
	// 1. Method adds strings (0,1,2, or more) if empty return 0
	// 2. Allow the Add method to handle new lines between numbers (instead of
	// commas).

	public int calculate(String input) {

		if (input.isEmpty()) {
			return 0;
		}
		Stream<String> list = Arrays.stream(input.split(",|\n"));
		return list.mapToInt(Integer::parseInt).sum();

		// 3. Support different delimiters - todo in next step
		/*
		 * to change a delimiter, the beginning of the string will contain a
		 * separate line that looks like this: “//[delimiter]\n[numbers…]” for
		 * example “//;\n1;2” should return three where the default delimiter is
		 * ‘;’ . the first line is optional. all existing scenarios should still
		 * be supported
		 */

	}
}
