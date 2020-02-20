package experience.cic;

import java.util.*;

public class Problem2 {

	public static int deleteProducts(List<Integer> ids, int m) {
		// 각 아이템 종류별로 몇 개씩 존재하는지 카운팅
		Map<Integer, Integer> map = new HashMap<>();
		for (int id : ids) {
			map.put(id, map.getOrDefault(id, 0) + 1);
		}

		// 아이템의 갯수만 리스트에 저장
		List<Integer> counts = new ArrayList<>();
		for (int key : map.keySet()) {
			counts.add(map.get(key));
		}

		// 아이템 갯수를 오름차순 정렬
		Collections.sort(counts);

		// 초기 아이템 종류수 설정
		int answer = map.size();
		int sum = 0;

		// 아이템 갯수가 적은 것부터 m개 제거하면서 남는 아이템 종류가 몇 개인지 카운팅
		for (int i = 0, len = counts.size(); i < len; i++) {
			sum += counts.get(i);
			if (sum <= m) {
				answer--;
			} else {
				break;
			}
		}

		// m개 제거 후 남은 아이템 종류 수 반환
		return answer;
	}

}
