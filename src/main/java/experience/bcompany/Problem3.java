package experience.bcompany;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

	public static int perfectSubstring(String s, int k) {
		int answer = 0;

		for (int startIndex = 0; startIndex <= s.length() - k; startIndex++) {
			ConditionChecker conditionChecker = new ConditionChecker(k);
			for (int presentIndex = startIndex; presentIndex < s.length(); presentIndex++) {
				int status = conditionChecker.getPresentStatus(s.charAt(presentIndex));

				// 조건을 만족할 수 있는 가능성이 사라진 상태
				if (status == -1) {
					break;
				}

				// 조건을 만족한 상태
				if (status == 1) {
					answer++;
				}
			}
		}

		return answer;
	}

	static class ConditionChecker {

		private int appearedNumberCount;

		private int satisfyCount;

		private int conditionCount;

		private Map<Character, Integer> map = new HashMap<>();

		public ConditionChecker(int conditionCount) {
			this.conditionCount = conditionCount;
		}

		public int getPresentStatus(char ch) {
			int numberCount = map.getOrDefault(ch, 0);
			map.put(ch, numberCount + 1);

			if (numberCount == 0) {
				appearedNumberCount++;
			}

			if (numberCount + 1 == conditionCount) {
				satisfyCount++;
			}

			// 조건 충족 가능성이 사라진 상태
			if (numberCount + 1 > conditionCount) {
				return -1;
			}

			// 조건을 충족하지 못한 상태
			if (satisfyCount != appearedNumberCount) {
				return 0;
			}

			// 조건을 충족한 상태
			return 1;
		}
	}
}