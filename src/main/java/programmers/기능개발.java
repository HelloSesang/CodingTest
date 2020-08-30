package programmers;

import java.util.ArrayList;
import java.util.List;

/*
	배포되어야 하는 순서대로 정렬된 정수 배열 progresses
	개발 속도가 적힌 정수 배열 speeds
	기능은 진도가 100%가 되어야 배포가 가능
	먼저 배포되어야 하는 기능이 아직 개발중이라면 뒤에 있는 기능은 개발이 완료되었더라도 대기
	매번 배포가 일어날 때마다 몇 개의 기능이 배포되는지 배열로 리턴하라.
 */

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        // 기능 개발에 필요한 기간을 담을 배열
        int[] nessaryPeriod = new int[progresses.length];

        // 기능 개발에 필요한 기간을 계산해서 배열에 담는다.
        for (int i = 0, len = progresses.length; i < len; i++) {
            // 남은 퍼센트를 구한다.
            int restPercent = 100 - progresses[i];
            // 남은 퍼센트를 하루 개발 속도로 나눈다.
            nessaryPeriod[i] = restPercent / speeds[i];

            // 나머지가 존재한다면 하루 더 필요하므로 하루 더 추가
            if (restPercent % speeds[i] != 0) {
                nessaryPeriod[i]++;
            }
        }

        // 정답을 담을 List 생성
        List<Integer> list = new ArrayList<>();

        // 초기값 설정
        int count = 1;
        int minPeriod = nessaryPeriod[0];

        // 2번째 기능의 개발에 필요한 기간부터 순차 접근하면서 먼저 배포 되어야하는 기능이 필요로 하는 기간과 비교를 한다.
        for (int i = 1, len = nessaryPeriod.length; i < len; i++) {
            // 현재 접근한 기능이 먼저 배포되어야 할 기능보다 먼저 또는 동시에 개발되는 경우 배포되는 기능의 수를 1 추가한다.
            if (nessaryPeriod[i] <= minPeriod) {
                count++;
                // 현재 접근한 기능이 먼저 배포되어야 할 기능보다 늦게 개발되는 경우 따로 배포할 것이므로 현재까지 카운팅한 배포할 기능 수를 list에 담고 변수를 초기화한다.
            } else {
                list.add(count);
                minPeriod = nessaryPeriod[i];
                count = 1;
            }

            // 현재 접근한 기능이 마지막 기능이라면 리스트에 마지막 값을 추가해줘야 한다.
            if (i + 1 >= len) {
                list.add(count);
            }
        }

        // List에 담긴 정답을 배열로 옮겨 담는다.
        int[] answer = new int[list.size()];
        for (int i = 0, len = answer.length; i < len; i++) {
            answer[i] = list.get(i);
        }

        // 정답을 반환
        return answer;
    }

}
