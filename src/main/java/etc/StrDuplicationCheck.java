package etc;

import java.util.HashMap;
import java.util.Map;

public class StrDuplicationCheck {

	public static void main(String[] args) {
		boolean result = solution("abcdefg");
		System.out.println(result);
	}

	private static boolean solution(String str) {
//		for (int i = 0, len = str.length(); i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				if (i == j) break;
//				if (str.charAt(i) == str.charAt(j)) {
//					return true;
//				}
//			}
//		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, len = str.length(); i < len; i++) {
			char now = str.charAt(i);
			int count = map.getOrDefault(now, 0);
			if (count > 0) return true;
			map.put(now, count + 1);
		}

		return false;
	}

}
