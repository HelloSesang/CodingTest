package experience.jobpair;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {

	public int solution(int[] goods, int[] boxes) {
		int answer = 0;

		// 박스 배열을 LinkedList로 옮겨담는다.
		List<Integer> boxList = new LinkedList<>();
		for (int e : boxes) {
			boxList.add(e);
		}

		// LinkedList를 오름차순 정렬한다.
		Collections.sort(boxList);

		// goods를 오름차순 정렬한다.
		Arrays.sort(goods);

		// goods에 순차접근한다.
		for (int i = goods.length - 1; i >= 0; i--) {
			// LinkedList에 순차접근한다.
			for (int j = 0, len = boxList.size(); j < len; j++) {
				// goods의 요소 값보다 LinkedList 요소 값이 큰 경우
				if (goods[i] <= boxList.get(j)) {
					// answer++;
					answer++;
					// 해당 LinkedList 요소를 제거한다.
					boxList.remove(j);
					break;
				}
			}
		}

		// 최종 결과를 반환한다.
		return answer;
	}

}