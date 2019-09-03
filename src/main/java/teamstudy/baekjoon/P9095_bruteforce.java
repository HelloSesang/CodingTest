package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9095_bruteforce {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		while (testCount-- > 0) {
			System.out.println(getAnswer(0, Integer.parseInt(br.readLine())));
		}
	}

	private static int getAnswer(int now, int target) {
		if (now == target) return 1;
		if (now > target) return 0;
		return getAnswer(now + 1, target) + getAnswer(now + 2, target) + getAnswer(now + 3, target);
	}

}
