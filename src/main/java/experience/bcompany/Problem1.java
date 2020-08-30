package experience.bcompany;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1 {

    private static final char OPEN1 = '(';
    private static final char OPEN2 = '{';
    private static final char OPEN3 = '[';

    private static final char CLOSE1 = ')';
    private static final char CLOSE2 = '}';
    private static final char CLOSE3 = ']';

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
        if (ch == OPEN1 || ch == OPEN2 || ch == OPEN3) {
            stack.push(ch);
            return stack;
        }

        if (ch == CLOSE1 && !stack.isEmpty() && stack.peek() == OPEN1) {
            stack.pop();
            return stack;
        }
        if (ch == CLOSE2 && !stack.isEmpty() && stack.peek() == OPEN2) {
            stack.pop();
            return stack;
        }
        if (ch == CLOSE3 && !stack.isEmpty() && stack.peek() == OPEN3) {
            stack.pop();
            return stack;
        }

        stack.push(ch);
        return stack;
    }

}
