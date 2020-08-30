package experience.bcompany;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Problem4Test {

    @Test
    public void maxInversions() {
        List<Integer> prices = Arrays.asList(5, 3, 4, 2, 1);
        assertThat(Problem4.maxInversions(prices)).isEqualTo(7);
    }
}