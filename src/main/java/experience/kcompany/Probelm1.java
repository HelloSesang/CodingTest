package experience.kcompany;

import java.util.*;

public class Probelm1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int result = reduceCapacity(list);
		System.out.println(result);
	}

	public static int reduceCapacity(List<Integer> model) {
		// 배열을 정렬한다.
		model.sort((o1, o2) -> o1 - o2);

		// 제거해야하는 수를 찾는다.
		int deactivateCount = (int)(Math.ceil((double)model.size() / 2));

		// 반복 횟수를 저장하기 위한 리스트 자료구조를 생성한다.
		List<Integer> repeatCounts = new ArrayList<>();

		int repeatCount = 1;

		// 배열에 순차접근한다.
		for (int i = 1, len = model.size(); i < len; i++) {
			// 값이 반복인 경우
			if (model.get(i - 1).equals(model.get(i))) {
				// 반복횟수를 카운팅 한다.
				repeatCount++;
			// 값이 달라진 경우
			} else {
				// 반복횟수를 리스트에 담고
				repeatCounts.add(repeatCount);
				// 카운트를 1로 초기화한다.
				repeatCount = 1;
			}
		}

		// 마지막 repeatCount 추가
		repeatCounts.add(repeatCount);

		// 반복 횟수가 저장된 리스트를 내림차순 정렬한다.
		repeatCounts.sort((o1, o2) -> o2-o1);

		int answer = 0;
		int sum = 0;
		// 반복 횟수의 합이 제거해야하는 양을 넘어설 때의 값을 반환한다.
		for (int i = 0, len = repeatCounts.size(); i < len; i++) {
			sum += repeatCounts.get(i);
			if (sum >= deactivateCount) {
				answer = i + 1;
				break;
			}
		}

		return answer;
	}

}
