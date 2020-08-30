package acm_icpc.year2013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sumOfGCD {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        while (testCnt-- > 0) {
            long answer = 0;
            long[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            for (int i = 1, len = input.length; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    answer += getGCD(input[i], input[j]);
                }
            }
            System.out.println(answer);
        }

    }

    private static long getGCD(long num1, long num2) {
        if (num2 == 0) return num1;
        return getGCD(num2, num1 % num2);
    }

}
