package real.stcompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1_retryTest {

	@Test
	public void solution() {
		Problem1_retry obj = new Problem1_retry();
		int result = obj.solution(new String[]{"eva","jqw","tyn", "jan"});
		assertEquals(9, result);
	}
}