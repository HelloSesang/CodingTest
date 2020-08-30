package topcoder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class InterestingPartyTest {

    @Test
    public void getMaximumNumber() {
        String[] first = {"fishing", "gardening", "swimming", "fishing"};
        String[] second = {"hunting", "fishing", "fishing", "biting"};
        assertThat(InterestingParty.getMaximumNumber(first, second))
                .isEqualTo(4);
    }
}