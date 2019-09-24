package real.stcompany;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem1Test {

	@Test
	public void solution() {
		Problem1 obj = new Problem1();
		int answer = obj.solution(new String[]{"abc","kkk","def", "csv"});
		System.out.println(answer);
	}
}