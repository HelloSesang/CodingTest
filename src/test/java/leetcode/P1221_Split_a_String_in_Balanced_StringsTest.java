package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class P1221_Split_a_String_in_Balanced_StringsTest {

    @ParameterizedTest
    @CsvSource(value = {"RLRRLLRLRL, 4", "RLLLLRRRLR, 3", "LLLLRRRR, 1"})
    public void balancedStringSplit(String input, int result) {
        P1221_Split_a_String_in_Balanced_Strings obj = new P1221_Split_a_String_in_Balanced_Strings();
        assertThat(obj.balancedStringSplit(input)).isEqualTo(result);
    }
}