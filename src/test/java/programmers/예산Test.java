package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 예산Test {

	@Test
	public void solution() {
		예산 obj = new 예산();
		assertEquals(4, obj.solution(new int[]{2,2,3,3}, 10));
	}
}