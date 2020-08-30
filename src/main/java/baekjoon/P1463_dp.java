package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1463_dp {

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        dp = new int[input + 1];
        int result = getMinimalCount(input);
        System.out.println(result);
    }

    private static int getMinimalCount(int input) {
        if (input <= 1) return 0;
        if (dp[input] > 0) return dp[input];
        int temp = 0;
        int min = getMinimalCount(input - 1);
        if (input % 2 == 0) {
            temp = getMinimalCount(input / 2);
            min = Math.min(temp, min);
        }
        if (input % 3 == 0) {
            temp = getMinimalCount(input / 3);
            min = Math.min(temp, min);
        }
        dp[input] = min + 1;
        return dp[input];
    }

}
