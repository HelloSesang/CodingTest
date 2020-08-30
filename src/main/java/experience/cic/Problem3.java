package experience.cic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {

    // 결과를 담을 리스트
    private static List<String> answer = new ArrayList<>();

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        // 재귀적으로 모든 경우의 수를 확인해서 정답을 만든다
        makeAnswers(pattern, dayHours, workHours);

        // 결과리스트를 사전순으로 정렬
        Collections.sort(answer);

        // 결과를 반환
        return answer;
    }

    public static void makeAnswers(String pattern, int dayHours, int workHours) {
        // ? 문자가 더 이상 존재하지 않는 경우
        if (!pattern.contains("?")) {
            int sum = 0;

            // 문자열의 각 문자에 순차접근
            for (int i = 0, len = pattern.length(); i < len; i++) {
                // 각 문자의 합을 구한다.
                sum += Character.getNumericValue(pattern.charAt(i));
            }

            // 문자의 총 합이 workHours와 같은 경우
            if (sum == workHours) {
                // 찾고자하는 값이므로 리스트에 추가한다.
                answer.add(pattern);
            }

            // 재귀호출을 빠져나간다.
            return;
        }

        // 가장 왼쪽의 ?문자에 0~dayHours 사이의 수를 채운 후 makeAnswers 메서드를 재귀호출
        for (int i = 0; i <= dayHours; i++) {
            String replaced = pattern.replaceFirst("\\?", String.valueOf(i));
            makeAnswers(replaced, dayHours, workHours);
        }
    }

}
