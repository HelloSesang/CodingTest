package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11727_dp {

    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        dp = new int[size + 1];
        System.out.println(getAnswer(size));
    }

    private static int getAnswer(int size) {
        if (size == 1) {
            return 1;
        }
        if (size == 2) {
            return 3;
        }
        if (dp[size] > 0) {
            return dp[size];
        }
        dp[size] = (getAnswer(size - 1) % 10007 + (getAnswer(size - 2) * 2) % 10007) % 10007;
        return dp[size];
    }

}
