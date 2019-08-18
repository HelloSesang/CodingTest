package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P11726_dp {

	private static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		dp = new int[size + 1];
		dp[0] = 1;
		dp[1] = 1;
		bw.write(String.valueOf(getSolutionCount(size)));
		bw.flush();
	}

	private static int getSolutionCount(int size) {
		if (dp[size] > 0) return dp[size];
		dp[size] = ((getSolutionCount(size - 1) % 10007) + (getSolutionCount(size - 2) % 10007)) % 10007;
		return dp[size];
	}

}
