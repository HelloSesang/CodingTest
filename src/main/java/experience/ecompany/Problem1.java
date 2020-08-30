package experience.ecompany;

/*
	문자열 S는 a, b로만 구성되어 있고 길이는 N이다.
	3번 동일 문자가 반복하지 않는 경우 semi-alternating substring이라고 한다.
	길이가 가장 긴 세미 뭐시기의 길이를 반환하라.
*/

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public int solution(String S) {
        int answer = 0;

        List<Integer> index = new ArrayList<>();
        index.add(-1);

        int repeatCount = 1;
        // 문자열의 문자에 순차접근
        for (int i = 1, len = S.length(); i < len; i++) {
            // 반복 횟수를 카운팅
            if (S.charAt(i - 1) == S.charAt(i)) {
                repeatCount++;
            } else {
                repeatCount = 1;
            }

            // 동일 문자가 3회 이상 중복된 경우
            if (repeatCount >= 3) {
                // List에 중복이 시작된 인덱스를 저장한다.
                index.add(i - 2);
            }
        }

        index.add(S.length());

        // 3회 중복 문자가 존재하지 않는 경우 처리
        if (index.size() <= 2) {
            return S.length();
        }

        // index 리스트에 순차 접근한다.
        for (int i = 1, len = index.size(); i < len; i++) {
            int right = index.get(i);
            int left = index.get(i - 1);

            // (현재 인덱스 요소 + 2) - (이전 인덱스 요소 + 1)이 answer보다 큰 경우
            if (answer < ((right + 2) - (left + 1))) {
                // answer = 현재 인덱스 요소 - (이전 인덱스 요소 + 1)
                answer = (right + 2) - (left + 1);
            }
        }

        // 최종 결과를 반환한다.
        return answer;
    }

}
