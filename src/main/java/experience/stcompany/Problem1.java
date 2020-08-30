package experience.stcompany;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    // A의 길이는 1 ~ 8
    // A 배열에 존재하는 문자열을 합쳐서 나온 결과중 조건을 만족하는 문자열의 길이를 반환
    // 조건을 만족하는 문자열이 없다면 0 리턴
    // A내 문자열은 전부 영문 소문자
    // 길이는 100을 넘지않는다.

    public int solution(String[] A) {
        int maxLength = 0;

        Arrays.sort(A, (o1, o2) -> o2.length() - o1.length());

        for (int i = 0, len = A.length; i < len; i++) {
            String start = A[i];

            if (!checkString(start)) {
                continue;
            }

            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                String target = A[j];

                if (!checkString(target)) {
                    continue;
                }

                boolean duplicationYn = false;
                for (int k = 0, len2 = target.length(); k < len2; k++) {
                    if (start.indexOf(target.charAt(k)) != -1) {
                        duplicationYn = true;
                    }
                }

                if (!duplicationYn) {
                    start += target;
                }
            }
            if (start.length() > A[i].length() && start.length() > maxLength) {
                maxLength = start.length();
            }
        }

        return maxLength;
    }

    private boolean checkString(String target) {
        Map<Character, Integer> map = new HashMap<>();

        boolean targetChecker = true;
        for (int i = 0, len = target.length(); i < len; i++) {
            if (map.getOrDefault(target.charAt(i), 0) != 0) {
                targetChecker = false;
                break;
            }
            map.put(target.charAt(i), 1);
        }

        return targetChecker;
    }

}
