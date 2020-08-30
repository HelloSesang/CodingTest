package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCD {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int answer = getGCD(a, b);
        System.out.println(answer);
    }

    private static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

}
