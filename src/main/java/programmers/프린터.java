package programmers;

/*
	중요도가 높은 문서를 먼저 인쇄하는 프린터
	현재 프린터의 대기목록 배열
	내가 요청한 프린터의 대기목록 내 인덱스
	내가 요청한 문서가 몇 번째로 인쇄되는지 리턴하라
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 프린터 {

    public int solution(int[] priorities, int location) {
        Deque<Integer> handleOrder = new ArrayDeque<>();

        // 대기목록을 큐에 집어넣는다.
        for (int e : priorities) {
            handleOrder.offerLast(e);
        }

        // 가장 높은 중요도를 확인하기 위한 변수
        int maxIdx = priorities.length - 1;
        Arrays.sort(priorities);

        int answer = 0;
        while (handleOrder.size() > 0) {
            // 현재 접근 값이 가장 높은 중요도를 가진 경우
            if (handleOrder.peekFirst() == priorities[maxIdx]) {
                // 현재 접근 값을 처리한다.
                handleOrder.pollFirst();
                // answer++;
                answer++;
                // maxIdx--;
                maxIdx--;
                // 만약 처리한 것이 타겟이라면 break;
                if (location == 0) {
                    break;
                }
                // 현재 접근 값이 가장 높은 중요도를 가지지 않은 경우
            } else {
                // 현재 접근 값을 큐의 맨 뒤로 옮긴다.
                handleOrder.offerLast(handleOrder.pollFirst());
            }
            // 타겟 인덱스 조정
            location = location - 1 < 0 ? handleOrder.size() - 1 : location - 1;
        }

        return answer;
    }

}
