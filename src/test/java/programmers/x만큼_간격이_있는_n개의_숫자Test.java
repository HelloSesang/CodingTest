package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class x만큼_간격이_있는_n개의_숫자Test {

    @Test
    public void solution() {
        x만큼_간격이_있는_n개의_숫자 obj = new x만큼_간격이_있는_n개의_숫자();
        assertArrayEquals(new long[]{2, 4, 6, 8, 10}, obj.solution(2, 5));
    }
}