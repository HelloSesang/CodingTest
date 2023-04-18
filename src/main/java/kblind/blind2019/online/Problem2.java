package kblind.blind2019.online;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 solution = new Problem2();
        String answer = solution.solution("()))((()");
        System.out.println(answer);
    }

    public String solution(String p) {
        if (p.equals("")) return p;
        return separate(p);
    }

    private String separate(String p) {
        Deque<Character> stack = new ArrayDeque<>();
        int index = getSeparateIndex(p, stack);
        boolean balanceYn = stack.size() == 0;

        // 마지막까지 도달해서 문자열 v가 더 이상 없는 경우
        if (index >= p.length()) {
            if (balanceYn) {
                return p;
            } else {
                return revise(p);
            }
        }

        // 문자열을 u, v로 나눌 수 있는 경우
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (balanceYn) {
            return u + separate(v);
        } else {
            u = revise(u);
            return "(" + separate(v) + ")" + u;
        }
    }

    // 문자열을 u와 v로 나누기 위한 인덱스를 찾는 메소드
    // 인덱스를 찾으면서 stack을 이용해 문자열 u가 올바른지 여부도 판단할 수 있도록 한다.
    private int getSeparateIndex(String p, Deque<Character> stack) {
        int leftCnt = 0;
        int rightCnt = 0;
        int i = 0;
        for (int len = p.length(); i < len; i++) {
            char now = p.charAt(i);
            if (now == '(') {
                stack.offerLast('(');
                leftCnt++;
            } else {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pollLast();
                } else {
                    stack.offerLast(')');
                }
                rightCnt++;
            }
            if (leftCnt == rightCnt) {
                break;
            }
        }
        return i;
    }

    // 문자열 u가 올바르지 않은 경우 이를 수정하는 메소드
    private String revise(String u) {
        String temp = u.substring(1, u.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0, len = temp.length(); j < len; j++) {
            if (temp.charAt(j) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}
