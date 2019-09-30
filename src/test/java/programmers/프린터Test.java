package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 프린터Test {

	@Test
	public void solution() {
		프린터 obj = new 프린터();
		assertEquals(5, obj.solution(new int[]{1,1,9,1,1,1}, 0));
	}
}