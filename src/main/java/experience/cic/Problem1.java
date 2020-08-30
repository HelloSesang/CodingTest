package experience.cic;

import java.util.List;

public class Problem1 {

    public static int maxStreak(int m, List<String> data) {
        int answer = 0;
        int count = 0;

        // data에 순차접근
        for (String info : data) {
            // 전 직원이 참석한 경우
            if (!info.contains("N")) {
                // 1일을 추가
                count++;
                // 전 직원이 참석한게 아닌 경우
            } else {
                // 전직원이 참석한게 최장일인 경우 answer에 대입하고 카운트를 초기화
                answer = Math.max(count, answer);
                count = 0;
            }
        }

        // 마지막 카운팅 값에 대한 최장일 확인
        answer = Math.max(count, answer);

        // 결과를 반환
        return answer;
    }

}
