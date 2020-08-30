package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 구명보트Test {

    @Test
    public void solution() {
        구명보트 obj = new 구명보트();
        assertEquals(3, obj.solution(new int[]{70, 69, 11, 10}, 81));
    }
}