package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1부터 n까지 더하기
public class AddOneToN {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int kind = n % 2 == 0 ? 0 : 1;
        int sum = 0;
        if (kind == 0) {
            sum = (n + 1) * (n / 2);
        } else {
            sum = ((n + 1) * (n / 2)) + ((n + 1) / 2);
        }

        System.out.println(sum);
    }

}
