package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579_dp {

	private static int[] dp;

	private static int[] score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairCount = Integer.parseInt(br.readLine());
		dp = new int[stairCount + 1];
		score = new int[stairCount + 1];
		for (int i = 1; i <= stairCount; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(getMaxScore(stairCount));
	}

	private static int getMaxScore(int stairNum) {
		if (stairNum == 0) return score[0];
		if (stairNum == 1) return score[1];
		if (stairNum == 2) return score[1] + score[2];
		if (dp[stairNum] > 0) return dp[stairNum];
		dp[stairNum] =  Math.max(score[stairNum - 1] + getMaxScore(stairNum - 3), getMaxScore(stairNum - 2)) + score[stairNum];
		return dp[stairNum];
	}

}
