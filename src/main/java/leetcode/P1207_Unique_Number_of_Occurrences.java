package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1207_Unique_Number_of_Occurrences {

    // Map에 각 숫자별 중복횟수를 저장한다.
    // Map에 저장된 중복횟수를 Set에 넣는다.
    // 요소의 갯수와 Set의 size가 같으면 true 아니면 false를 반환

    public boolean uniqueOccurrences(int[] arr) {
        // answer 변수를 선언한다.
        boolean answer = true;

        // Map 객체를 생성
        Map<Integer, Integer> map = new HashMap<>();

        // arr의 요소에 순차접근
        for (int e : arr) {
            // Map에 요소별 중복횟수를 저장한다.
            int count = map.getOrDefault(e, 0);
            map.put(e, count + 1);
        }

        // Set 객체를 생성
        Set<Integer> set = new HashSet<>();

        // Map의 Value에 순차접근해서 set에 value를 담는다.
        Set mapSet = map.keySet();
        mapSet.forEach(o -> set.add(map.get(o)));

        // Set의 사이즈와 Map의 키의 갯수가 동일한 경우
        if (set.size() != mapSet.size()) {
            // answer에 false를 대입한다.
            answer = false;
        }

        // 최종결과를 반환한다.
        return answer;
    }

}
