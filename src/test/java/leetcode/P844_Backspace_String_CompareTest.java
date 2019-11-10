package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class P844_Backspace_String_CompareTest {

	@ParameterizedTest
	@CsvSource(value = {"ab#c, ad#c, true", "ab##, c#d#, true", "a##c, #a#c, true", "a#c, b, false"})
	public void backspaceCompare(String S, String T, boolean expect) {
		P844_Backspace_String_Compare obj = new P844_Backspace_String_Compare();
		assertThat(obj.backspaceCompare(S, T)).isEqualTo(expect);
	}
}