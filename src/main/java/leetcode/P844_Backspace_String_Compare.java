package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P844_Backspace_String_Compare {

    private static final char BACKSPACE = '#';

    public boolean backspaceCompare(String S, String T) {
        // 최종 결과를 저장할 Stack 자료구조
        Deque<Character> stackForS = new ArrayDeque<>();
        Deque<Character> stackForT = new ArrayDeque<>();

        // Stack을 완성시키는 메서드
        makeStackForResultString(S, stackForS);
        makeStackForResultString(T, stackForT);

        // 두 스택의 사이즈를 비교한다.
        // 사이즈가 다른 경우
        if (stackForS.size() != stackForT.size()) {
            // return false;
            return false;
        }

        // 사이즈가 같은 경우
        while (!stackForS.isEmpty()) {
            // 두 스택에서 문자를 하나씩 꺼내서 비교한다.
            // 문자가 다른 경우
            if (stackForS.pop() != stackForT.pop()) {
                // return false
                return false;
            }
        }

        // 두 문자열이 동일한 것이므로 true 반환
        return true;
    }

    private void makeStackForResultString(String target, Deque<Character> stack) {
        // target의 문자에 순차접근한다.
        for (char ch : target.toCharArray()) {
            // 문자가 #이 아닌 경우
            if (ch != BACKSPACE) {
                // 스택에 해당 문자를 넣는다.
                stack.push(ch);
                continue;
            }
            // 문자가 #인 경우
            if (ch == BACKSPACE && !stack.isEmpty()) {
                // 스택에서 문자를 하나 제거한다.
                stack.pop();
                continue;
            }
        }
    }

}
