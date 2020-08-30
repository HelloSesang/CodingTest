package experience.bcompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class Problem2Test {

    @ParameterizedTest
    @CsvSource(value = {"programmerxxxprozmerqgram, 3", "xprogxrmaxemrppprmmograeiruu, 2"})
    public void programmerStrings(String input, int expected) {
        assertThat(Problem2.programmerStrings(input)).isEqualTo(expected);
    }

    @Test
    void programmerStrings() {
        assertThrows(IllegalArgumentException.class, () ->
                Problem2.programmerStrings(null)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"programmerxxxprozmerqgram, 9"})
    void findLeftProgrammerStringEndIndex(String input, int expected) {
        assertThat(Problem2.findLeftProgrammerStringEndIndex(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"programmerxxxprozmerqgram, 13"})
    void findRightProgrammerStringStartIndex(String input, int expected) {
        assertThat(Problem2.findRightProgrammerStringStartIndex(input)).isEqualTo(expected);
    }
}