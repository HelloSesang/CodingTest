package experience.zcompany;

import java.util.*;

public class Problem4 {

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.solution("0110011"));
    }

    public int solution(String s) {
        // 스택을 하나 생성
        Deque<Character> stack = new ArrayDeque<>();

        // 문자열의 각 문자에 순차접근
        for (char ch : s.toCharArray()) {
            char top = ' ';
            if (stack.size() > 0) {
                top = stack.peekLast();
            }
            // 이전 입력값과 현재 접근한 값이 서로 다른 경우
            if (top != ' ' && top != ch) {
                // 스택에서 문자 하나를 제거
                stack.pollLast();
                // 같은 경우
            } else {
                // 스택에 문자 삽입
                stack.offerLast(ch);
            }
        }
        // 스택의 사이즈를 반환
        return stack.size();
    }
}