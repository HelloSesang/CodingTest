package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P859_Buddy_Strings {

	public boolean buddyStrings(String A, String B) {
		// 문자열의 길이가 다른 경우
		if (A.length() != B.length()) {
			return false;
		}

		// 문자열이 같은 경우
		if (A.equals(B)) {
			Set<Character> set = new HashSet<>();
			for (int i = 0, len = A.length(); i < len; i++) {
				set.add(A.charAt(i));
			}

			// 중복되는 문자가 없는 경우
			if (set.size() == A.length()) {
				// 교환해서 같은 문자열을 만들 수 없다.
				return false;
			}
		}

		// 문자열이 다른 경우
		if (!A.equals(B)) {
		    // 문자가 서로 다른 위치의 인덱스 값을 저장한다.
			List<Integer> list = new ArrayList<>();
			for (int i = 0, len = A.length(); i < len; i++) {
				if (A.charAt(i) != B.charAt(i)) {
					list.add(i);
				}
			}

			// 서로 다른 곳이 2곳이 아닌 경우
			if (list.size() != 2) {
			    // 교환해서 동일한 문자열을 만들 수 없다.
				return false;
			}

			int first = list.get(0);
			int second = list.get(1);

			// 서로 다른 곳이 2곳이지만 교환해서 동일한 문자열이 안만들어지는 경우
			if (A.charAt(first) != B.charAt(second) || A.charAt(second) != B.charAt(first)) {
				return false;
			}
		}

		// 교환해서 동일한 문자열을 만들 수 있는 경우
		return true;
	}

}
