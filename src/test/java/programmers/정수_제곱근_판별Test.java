package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 정수_제곱근_판별Test {

    @Test
    public void solution() {
        정수_제곱근_판별 obj = new 정수_제곱근_판별();
        assertEquals(-1, obj.solution(3));
    }
}