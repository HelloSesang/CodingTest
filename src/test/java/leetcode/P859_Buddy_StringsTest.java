package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class P859_Buddy_StringsTest {

    @Test
    void buddyStrings() {
        P859_Buddy_Strings obj = new P859_Buddy_Strings();
        assertThat(obj.buddyStrings("ab", "ab")).isEqualTo(false);
    }
}