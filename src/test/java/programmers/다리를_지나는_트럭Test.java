package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 다리를_지나는_트럭Test {

	@Test
	public void solution() {
		다리를_지나는_트럭 obj = new 다리를_지나는_트럭();
		assertEquals(110, obj.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
	}
}