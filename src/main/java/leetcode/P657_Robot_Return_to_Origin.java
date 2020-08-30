package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P657_Robot_Return_to_Origin {

    public boolean judgeCircle(String moves) {
        boolean answer = true;

        Map<Character, Integer> map = new HashMap<>();

        // moves 문자열의 문자에 순차접근
        for (char ch : moves.toCharArray()) {
            // Map에 방향별 움직인 횟수를 저장한다.
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        int upCount = map.getOrDefault('U', 0);
        int downCount = map.getOrDefault('D', 0);
        int leftCount = map.getOrDefault('L', 0);
        int rightCount = map.getOrDefault('R', 0);

        // 위아래 방향 움직인 횟수와 오른쪽왼쪽 움직인 횟수가 서로 동일한지 비교한다.
        // 동일하지 않은 경우
        if (upCount != downCount || leftCount != rightCount) {
            // answer를 false로 변경한다.
            answer = false;
        }

        // 최종 결과를 반환한다.
        return answer;
    }

}
