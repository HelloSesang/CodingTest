package programmers;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {

    public long[] solution(long x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x + (x * i);
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

}
