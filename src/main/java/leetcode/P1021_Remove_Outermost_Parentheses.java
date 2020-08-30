package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1021_Remove_Outermost_Parentheses {

    public static void main(String[] args) {
        P1021_Remove_Outermost_Parentheses obj = new P1021_Remove_Outermost_Parentheses();
        String answer = obj.removeOuterParentheses("(()())(())");
        System.out.println(answer);
    }

    public String removeOuterParentheses(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = S.length(); i < len; i++) {
            char now = S.charAt(i);
            if (now == '(') {
                if (stack.size() != 0) {
                    sb.append(now);
                }
                stack.offerLast(now);
            }
            if (now == ')') {
                stack.pollLast();
                if (stack.size() == 0) {
                    answer.append(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(now);
                }
            }
        }

        return answer.toString();
    }

}
