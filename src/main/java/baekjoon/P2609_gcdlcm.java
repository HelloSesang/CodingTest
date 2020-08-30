package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2609_gcdlcm {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        int gcd = gcd(first, second);
        System.out.println(gcd);
        System.out.println(first * second / gcd);
    }

    private static int gcd(int first, int second) {
        if (second == 0) return first;
        int temp = second;
        second = first % second;
        first = temp;
        return gcd(first, second);
    }

}
