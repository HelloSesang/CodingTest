package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1221_Split_a_String_in_Balanced_Strings {

	private Deque<Character> stack = new ArrayDeque<>();

	public int balancedStringSplit(String s) {
		int answer = 0;
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(ch);
				continue;
			}

			if (stack.peek() == ch) {
				stack.push(ch);
				continue;
			}

			if (stack.peek() != ch) {
				stack.pop();
				if (stack.isEmpty()) {
					answer++;
				}
			}
		}
		return answer;
	}

}
