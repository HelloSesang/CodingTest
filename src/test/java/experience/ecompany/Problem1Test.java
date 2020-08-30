package experience.ecompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1Test {

    @Test
    public void solution() {
        Problem1 obj = new Problem1();
        int result = obj.solution("abaaaa");
        assertEquals(4, result);
    }
}