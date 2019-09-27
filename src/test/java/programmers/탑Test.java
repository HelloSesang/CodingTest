package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class 탑Test {

	@Test
	public void solution() {
		탑 obj = new 탑();
		assertArrayEquals(new int[]{0,0,0,3,3,3,6}, obj.solution(new int[]{3,9,9,3,5,7,2}));
	}
}