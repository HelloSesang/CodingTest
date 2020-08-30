package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 기능개발Test {

    @Test
    public void solution() {
        기능개발 obj = new 기능개발();
        int[] progresses = {40, 93, 30, 55, 60, 65};
        int[] speeds = {60, 1, 30, 5, 10, 7};
        assertArrayEquals(new int[]{1, 2, 3}, obj.solution(progresses, speeds));
    }
}