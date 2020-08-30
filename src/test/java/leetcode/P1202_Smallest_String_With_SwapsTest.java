package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class P1202_Smallest_String_With_SwapsTest {

    @Test
    void smallestStringWithSwaps() {
        P1202_Smallest_String_With_Swaps obj = new P1202_Smallest_String_With_Swaps();
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));
        assertThat(obj.smallestStringWithSwaps("dcab", pairs)).isEqualTo("abcd");
    }
}