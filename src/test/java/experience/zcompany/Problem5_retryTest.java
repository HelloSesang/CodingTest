package experience.zcompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem5_retryTest {

	@Test
	public void solution() {
		Problem5_retry obj = new Problem5_retry();
		int result = obj.solution(new int[] {4, 1});
		assertEquals(0, result);
	}
}