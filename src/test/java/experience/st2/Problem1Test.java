package experience.st2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Problem1Test {

    @Test
    public void solution() {
        Problem1 obj = new Problem1();
        int[] result = obj.solution(999999);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{5, 8}, result);
    }
}