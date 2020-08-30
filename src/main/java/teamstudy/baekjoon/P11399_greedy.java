package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11399_greedy {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.parseInt(br.readLine());
        int[] timeArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(timeArr);
        int answer = 0;
        for (int i = 0, len = timeArr.length; i < len; i++) {
            answer += (timeArr[i] * (len - i));
        }
        System.out.println(answer);
    }

}
