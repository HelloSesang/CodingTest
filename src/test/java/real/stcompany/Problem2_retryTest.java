package real.stcompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem2_retryTest {

	@Test
	public void solution() {
		Problem2_retry obj = new Problem2_retry();
		int result = obj.solution("codility");
		assertEquals(-1, result);
	}
}