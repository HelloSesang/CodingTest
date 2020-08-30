package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1934_lcm {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        while (testCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcd = getGCD(num1, num2);
            int lcm = (num1 * num2) / gcd;
            System.out.println(lcm);
        }
    }

    private static int getGCD(int num1, int num2) {
        if (num2 == 0)
            return num1;
        int temp = num2;
        num2 = num1 % num2;
        num1 = temp;
        return getGCD(num1, num2);
    }

}
