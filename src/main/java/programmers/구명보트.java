package programmers;

/*
	구명보트는 최대 2명이 탈 수 있으며 무게 제한이 있다.
	사람들의 몸무게를 담은 배열 people
	구명보트의 무게 제한 limit
	구명보트를 최대한 적게 사용하여 모든 사람을 구출할 때 필요한 구명보트의 개수
 */

import java.util.*;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        // 먼저 사람들을 정렬한다.
        Arrays.sort(people);

        // 정답을 담을 변수 선언
        int answer = 0;

        // 무게가 적게 나가는 사람과 무게가 많이 나가는 사람을 가리킬 인덱스 변수 생성
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            // 마지막에 한 사람만 남은 경우 보트를 한 대 더 사용하지 끝낸다.
            if (left == right) {
                answer++;
                break;
            }

            // 최저 무게 + 최고 무게가 limit보다 작거나 같은 경우
            if (people[left] + people[right] <= limit) {
                // 최저 무게인 사람 태워보낸다.
                left++;
            }
            // 무게 합의 limit 초과 여부에 상관없이
            // 최고 무게인 사람 태워보낸다.
            right--;

            // 보트 한 척을 사용했으니 카운팅한다.
            answer++;
        }

        // 정답 반환
        return answer;
    }

}
