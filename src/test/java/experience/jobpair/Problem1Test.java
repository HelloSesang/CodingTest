package experience.jobpair;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1Test {

    @Test
    public void solution() {
        Problem1 obj = new Problem1();
        int result = obj.solution(new int[]{3, 8, 6}, new int[]{5, 6, 4});
        assertEquals(2, result);
    }
}