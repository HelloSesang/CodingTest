package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	브루트포스로 문제 풀이
 */
public class P2003_bruteforce {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int numberCount = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getAnswer(target, numbers));
    }

    // O(n제곱)
    private static int getAnswer(int target, int[] numbers) {
        int answer = 0;
        for (int i = 0, len = numbers.length; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += numbers[j];
                if (sum >= target) {
                    if (sum == target) answer++;
                    break;
                }
            }
        }
        return answer;
    }

}
