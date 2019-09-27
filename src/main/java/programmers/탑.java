package programmers;

/*
	탑 N대
	탑 꼭대기에 신호 송/수신 장치
	탑의 높이 heights 배열
	각각의 탑이 쏜 신호를 어느 탑에서 받았는지를 배열에 기록해서 반환하라
 */

public class 탑 {

	public int[] solution(int[] heights) {
		// 정답을 담을 배열 생성
		int[] answer = new int[heights.length];

		// 각각의 탑에 순차접근
		for (int i = 0; i < heights.length; i++) {
			// 가장 왼쪽 탑은 아무도 신호를 받지 못하므로 바로 처리해준다.
			if (i == 0) {
				answer[i] = 0;
				continue;
			}
			// 접근한 타겟 탑이 송신한 신호를 누가 받을 수 있는지 찾는다.
			for (int j = i - 1; j >= 0; j--) {
				if (heights[j] > heights[i]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}

}
