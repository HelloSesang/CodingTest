package topcoder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class KiwiJuiceTest {

    @Test
    public void thePouring() {
        KiwiJuice kiwiJuice = new KiwiJuice();
        int[] capacities = {14, 35, 86, 58, 25, 62};
        int[] bottles = {6, 34, 27, 38, 9, 60};
        int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
        int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};

        assertThat(kiwiJuice.thePouring(capacities, bottles, fromId, toId))
                .containsExactly(0, 14, 65, 35, 25, 35);
    }
}