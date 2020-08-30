package experience.zcompany;

import java.util.ArrayList;
import java.util.List;

public class Problem5_retry {

    public int solution(int[] foods) {
        // 정답을 담을 변수
        int answer = 0;

        // 음식으로 얻을 수 있는 총 포만도를 구한다.
        int sum = 0;
        for (int num : foods) {
            sum += num;
        }

        // 공평하게 분배가 안되는 경우 바로 처리한다.
        if (sum % 3 != 0 || foods.length < 3) {
            return answer;
        }

        // 포만도를 몇 씩 주면 되는지 구한다.
        int average = sum / 3;

        List<Integer> candiateOfX = new ArrayList<>();
        List<Integer> candiateOfY = new ArrayList<>();

        int temp = 0;
        // 첫 째에게 평균 포만도를 줄 수 있는 인덱스를 전부 구한다.
        for (int i = 0, len = foods.length; i < len; i++) {
            temp += foods[i];
            if (temp == average) {
                candiateOfX.add(i);
            }
        }

        temp = 0;
        // 셋 째에게 평균 포만도를 줄 수 있는 인덱스를 전부 구한다.
        for (int i = foods.length - 1; i >= 0; i--) {
            temp += foods[i];
            if (temp == average) {
                candiateOfY.add(i);
            }
        }

        // 첫 째와 셋 째를 만족하는 후보들 중 둘 째까지 만족하는 것을 갯수를 카운팅한다.
        for (int x : candiateOfX) {
            for (int y : candiateOfY) {
                if (x >= y) {
                    break;
                }
                temp = 0;
                for (int i = x + 1; i < y; i++) {
                    temp += foods[i];
                }
                if (temp == average) {
                    answer++;
                }
            }
        }

        // 최종 결과를 반환한다.
        return answer;
    }

}
