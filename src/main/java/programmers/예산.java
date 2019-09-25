package programmers;

import java.util.Arrays;

public class 예산 {

	public int solution(int[] d, int budget) {
		Arrays.sort(d);

		int answer = 0;

		int sum = 0;
		for (int i = 0, len = d.length; i < len; i++) {
			sum += d[i];
			if (sum  > budget) {
				break;
			} else {
				answer++;
			}
		}

		return answer;
	}

}
