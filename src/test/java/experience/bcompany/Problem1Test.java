package experience.bcompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.*;

public class Problem1Test {

	@Test
	void braces() {
		String[] input = {"{{}}", "[{()}]", "{)}", "){}", "[]["};
		String[] expected = {"YES", "YES", "NO", "NO", "NO"};
		assertThat(Problem1.braces(input)).containsExactly(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"{{}}, YES", "[{()}], YES", "{)}, NO", "){}, NO", "[][, NO"})
	void dealWithString(String input, String expected) {
		assertThat(Problem1.dealWithString(input)).isEqualTo(expected);
	}

	@Test
	void dealWithChar() {
		Deque<Character> stack = new ArrayDeque<>();
		assertThat(Problem1.dealWithChar('(', stack)).isEqualTo(stack);
	}
}