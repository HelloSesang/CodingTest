package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798_BruteForce {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cardCnt = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        String[] input = br.readLine().split(" ");
        int[] card = new int[cardCnt];
        for (int i = 0; i < cardCnt; i++) {
            card[i] = Integer.parseInt(input[i]);
        }

        int answer = 0;
        for (int i = 0; i < cardCnt; i++) {
            for (int j = 0; j < cardCnt; j++) {
                if (i == j) continue;
                for (int k = 0; k < cardCnt; k++) {
                    if (i == k || j == k) continue;
                    int cardSum = card[i] + card[j] + card[k];
                    if (cardSum > max) continue;
                    if (cardSum > answer) answer = cardSum;
                }
            }
            if (answer == max) break;
        }
        System.out.println(answer);
    }

}
