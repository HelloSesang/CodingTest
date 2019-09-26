package programmers;

/*
	모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는가?
	트럭은 1초에 1만큼 움직인다.
	다리 길이는 bridge_length
	다리가 견딜 수 있는 무게 weight
 */

import java.util.*;

public class 다리를_지나는_트럭 {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int elapseTime = 0;
		Deque<Integer> before = new ArrayDeque<>();
		Deque<Integer> bridge = new ArrayDeque<>();
		Deque<Integer> after = new ArrayDeque<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int e : truck_weights) {
			before.offerLast(e);
		}

		int count = 0;
		while (after.size() < truck_weights.length) {
			// 시간 경과
			elapseTime++;

			// 다리 위의 차 위치 + 1
			// 끝에 도달한 차는 after로 이동
			map.keySet().forEach(turn -> {
				int beforeDistance = map.get(turn);

				if (beforeDistance < bridge_length) {
					map.put(turn, beforeDistance + 1);
					if (map.get(turn) >= bridge_length) {
						after.offerLast(bridge.pollFirst());
					}
				}
			});

			// 현재 다리가 견디는 무게를 확인
			int curWeight = bridge.stream().mapToInt(value -> value).sum();

			// 다음 차가 올라가도 무게를 견딘다면 차를 올린다.
			if (before.size() != 0 && curWeight + before.peekFirst() <= weight) {
				bridge.offerLast(before.pollFirst());
				// 몇번째 차가 얼마만큼 지나갔는지를 알 수 있는 정보를 map에 저장
				map.put(++count, 0);
			}

		}

		// 최종 경과시간을 반환한다.
		return elapseTime;
	}

}
