package experience.bcompany;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

	public static int perfectSubstring(String s, int k) {
		int answer = 0;

		for (int i = 0; i <= s.length() - k; i++) {
			ConditionChecker conditionChecker = new ConditionChecker(k);
			for (int j = i; j < s.length(); j++) {
				int status = conditionChecker.getStatus(s.charAt(j));

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

	private static boolean checkSubstring(int startIndex, int endIndex) {
		return false;
	}

	static class ConditionChecker {

		private int appearedNumberCount;

		private int satisfyCount;

		private int conditionCount;

		private Map<Character, Integer> map = new HashMap<>();

		public ConditionChecker(int conditionCount) {
			this.conditionCount = conditionCount;
		}

		public int getStatus(char ch) {
			int numberCount = map.getOrDefault(ch, 0);
			map.put(ch, numberCount + 1);

			if (numberCount == 0) {
				appearedNumberCount++;
			}

			if (numberCount + 1 == conditionCount) {
				satisfyCount++;
			}

			if (numberCount + 1 > conditionCount) {
				return -1;
			}

			if (satisfyCount != appearedNumberCount) {
				return 0;
			}

			return 1;
		}
	}
}