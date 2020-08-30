package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P10799_stack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0, len = input.length(); i < len; i++) {
            switch (input.charAt(i)) {
                case '(':
                    stack.offerLast(i);
                    break;
                case ')':
                    if (stack.pollLast() == i - 1) {
                        answer += stack.size();
                    } else {
                        answer += 1;
                    }
                    break;
            }
        }
        System.out.println(answer);
    }

}
