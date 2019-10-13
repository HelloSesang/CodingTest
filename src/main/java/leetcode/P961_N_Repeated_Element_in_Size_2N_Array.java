package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P961_N_Repeated_Element_in_Size_2N_Array {

	public int repeatedNTimes(int[] A) {
		// N이 몇인지 구한다.
		int n = A.length / 2;

		Map<Integer, Integer> map = new HashMap<>();

		// 배열 A에 순차접근한다.
		for (int i = 0, len = A.length; i < len; i++) {
			// 현재 요소를 가져온다.
			int now = A[i];
			// 각 요소의 값을 키로 반복횟수를 value로 저장한다.
			int count = map.getOrDefault(now, 0);
			map.put(now, count + 1);
		}

		int answer = 0;

		// map에 순차접근한다.
		for (int e : map.keySet()) {
			// 반복횟수가 N과 동일한 것을 찾아서 반환한다.
			if (map.get(e) == n) {
				answer = e;
				break;
			}
		}

		return answer;
	}

}
