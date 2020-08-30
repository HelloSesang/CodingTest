package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2439_printStar {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < count; j++) {
                if (j + i + 1 >= count) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            System.out.println(sb);
        }
    }

}
