package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimeNumber {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        boolean flag = true;
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            flag = true;
            if (value <= 1) continue;
            if (value == 3) {
                result++;
                continue;
            }
            for (int i = 2; i * i <= value; i++) {
                if (value % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        System.out.println(result);
    }

}
