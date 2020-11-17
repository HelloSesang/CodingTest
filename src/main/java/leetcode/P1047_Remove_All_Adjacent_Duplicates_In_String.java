package leetcode;

import java.util.Stack;

public class P1047_Remove_All_Adjacent_Duplicates_In_String {

	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();

		for (char ch : S.toCharArray()) {
			if (!stack.empty() && stack.peek() == ch) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (char ch : stack) {
			sb.append(ch);
		}
		return sb.toString();
	}

}
