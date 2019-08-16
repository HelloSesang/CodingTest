package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {

	private static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		dp = new int[count + 1];
		System.out.println(fibonacci(count));
	}

	private static int fibonacci(int idx) {
		if (idx <= 2) return 1;
		if (dp[idx] > 0) {
			return dp[idx];
		} else {
			dp[idx] = fibonacci(idx - 1) + fibonacci(idx - 2);
			return dp[idx];
		}
	}
}
