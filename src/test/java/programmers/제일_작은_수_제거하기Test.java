package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 제일_작은_수_제거하기Test {

    @Test
    public void solution() {
        제일_작은_수_제거하기 obj = new 제일_작은_수_제거하기();
        assertArrayEquals(new int[]{4, 3, 2}, obj.solution(new int[]{4, 3, 2, 1}));
    }
}