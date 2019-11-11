package experience.bcompany;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1 {

	private static final char open1 = '(';
	private static final char open2 = '{';
	private static final char open3 = '[';

	private static final char close1 = ')';
	private static final char close2 = '}';
	private static final char close3 = ']';

	// Complete the braces function below.
	static String[] braces(String[] values) {

		String[] answer = new String[values.length];

		// 주어진 문자열 배열에 순차 접근
		for (int i = 0, len = values.length; i < len; i++) {
			answer[i] = dealWithString(values[i]);
		}

		return answer;
	}

	// 문자열의 각 문자에 순차 접근
	static String dealWithString(String value) {
		Deque<Character> stack = new ArrayDeque<>();

		for (char ch : value.toCharArray()) {
			dealWithChar(ch, stack);
		}

		if (stack.isEmpty()) {
			return "YES";
		}
		return "NO";
	}

	// 각 문자가 만드는 괄호 스택을 완성
	static Deque<Character> dealWithChar(char ch, Deque<Character> stack) {
		if (ch == open1 || ch == open2 || ch == open3) {
			stack.push(ch);
			return stack;
		}

		if (ch == close1 && !stack.isEmpty() && stack.peek() == open1) {
			stack.pop();
			return stack;
		}
		if (ch == close2 && !stack.isEmpty() && stack.peek() == open2) {
			stack.pop();
			return stack;
		}
		if (ch == close3 && !stack.isEmpty() && stack.peek() == open3) {
			stack.pop();
			return stack;
		}

		stack.push(ch);
		return stack;
	}

}
