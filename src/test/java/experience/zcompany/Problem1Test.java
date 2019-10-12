package experience.zcompany;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Problem1Test {

	@Test
	public void solution() {

		Problem1 obj = new Problem1();
		int[][] result = obj.solution(new int[][] {{1,2,1},{2,3,1},{3,2,1}});
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}
}