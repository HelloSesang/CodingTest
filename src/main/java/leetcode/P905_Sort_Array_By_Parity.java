package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P905_Sort_Array_By_Parity {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> list = new ArrayList<>();

        // A배열에 순차접근한다.
        for (int e : A) {
            // 짝수를 모두 담는다.
            if (e % 2 == 0) {
                list.add(e);
            }
        }

        // A배열에 순차접근한다.
        for (int e : A) {
            // 홀수를 모두 담는다.
            if (e % 2 != 0) {
                list.add(e);
            }
        }

        // 정답을 담을 배열
        int[] answer = new int[list.size()];

        // 리스트의 내용을 옮겨 담는다.
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        // 최종 결과를 반환
        return answer;
    }

}
