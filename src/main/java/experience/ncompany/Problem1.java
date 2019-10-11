package experience.ncompany;

/*
	곤충 카드 모으기
	곤충 카드의 종류별 갯수를 동일하게 맞추고 싶다.
	한 장만 더 살 수 있다.
	한 장만 더 사서 갯수를 맞출 수 있는 구하라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Problem1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 보유 중인 카드의 수
		int cardCount = Integer.parseInt(br.readLine());

		// 보유 중인 카드의 종류
		String[] cards = br.readLine().split(" ");

		Map<String, Integer> map = new HashMap<>();

		// map에 카드별 갯수를 저장한다.
		for (String e : cards) {
			int count = map.getOrDefault(e, 0);
			map.put(e, count + 1);
		}

		Set<String> set = map.keySet();

		// 가장 적게 가진 카드의 숫자를 찾는다.
		// 카드의 숫자가 전부 동일한지 아닌지 여부도 판단한다.
		int min = 0;
		boolean buyYn = false;
		for (String e : map.keySet()) {
			int now = map.get(e);
			if (min == 0) {
				min = now;
			}

			if (min != now) {
				buyYn = true;
			}

			if(now < min) {
				min = now;
			}
		}

		// 카드의 숫자가 다른 경우
		if (buyYn) {
			// 가장 적게 가진 카드를 하나만 사서 추가한 결과를 만들어 본다.
			for (String e : map.keySet()) {
				if (map.get(e) == min) {
					map.put(e, min + 1);
					break;
				}
			}
		}

		// 최종적으로 완성된 상태에서 카드별 숫자가 전부 같은지 확인한다.
		boolean possibility = true;
		int count = 0;
		for (String e : map.keySet()) {
			if (count == 0) {
				count = map.get(e);
			}

			if (count != map.get(e)) {
				possibility = false;
			}
		}

		// 종류별로 개수를 동일하게 만들 수 있을지의 여부 (Y, N)
		System.out.println(possibility ? "Y" : "N");

		// 최종 보유한 카드의 총 개수
		if (possibility && buyYn) {
			// 카드를 한장 추가해서 카드의 수를 맞춘 경우 최초 카드수 + 1을 출력한다.
			System.out.println(cardCount + 1);
		} else {
			// 카드를 추가하지 않았거나 제대로 완성하지 못한 경우 기존 카드수를 출력한다.
			System.out.println(cardCount);
		}

		// 최종 보유한 카드의 종류 수
		System.out.println(set.size());
	}

}
