package experience.stcompany;

import java.util.Arrays;

public class TestProblem {

	public int solution(int[] A) {
		Arrays.sort(A);

		int max = A[A.length - 1];
		int answer = 1;
		for (int i = 1; i <= max + 1; i++) {
			int result = Arrays.binarySearch(A, i);
			if (result < 0) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}
