package experience.zcompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem3_retryTest {

	@Test
	public void solution() {

		Problem3_retry obj = new Problem3_retry();
		int result = obj.solution(new String[] {"D5","E8","G2"});
		assertEquals(42, result);
	}
}