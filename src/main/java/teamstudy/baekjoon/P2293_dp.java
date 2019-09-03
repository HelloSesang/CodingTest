package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2293_dp {

	private static int[] dp;

	private static int[] tokens;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int tokenCount = Integer.parseInt(st.nextToken());
		int want = Integer.parseInt(st.nextToken());

		tokens = new int[tokenCount + 1];
		dp = new int[want + 1];

		for (int i = 1; i <= tokenCount; i++) {
			tokens[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		for (int i = 1; i <= tokenCount; i++) {
			for (int j = 0; j <= want; j++) {
				if (j - tokens[i] >= 0) {
					dp[j] = dp[j] + dp[j - tokens[i]];
				}
			}
		}

		System.out.println(dp[want]);
	}

}
