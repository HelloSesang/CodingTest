package experience.bcompany;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class Problem3Test {

    @ParameterizedTest
    @CsvSource(value = {"1221221121, 3, 3", "1102021222, 2, 6"})
    public void perfectSubstring(String s, int k, int expected) {
        assertThat(Problem3.perfectSubstring(s, k)).isEqualTo(expected);
    }
}