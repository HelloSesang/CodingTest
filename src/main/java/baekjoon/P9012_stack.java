package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P9012_stack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque();
            boolean result = true;
            int len = input.length();
            for (int i = 0; i < len; i++) {
                if (!result) break;
                switch (input.charAt(i)) {
                    case '(':
                        stack.offerLast('(');
                        break;
                    case ')':
                        if (stack.pollLast() != null || stack.pollLast() != '(')
                            result = false;
                        break;
                }
            }
            if (stack.size() > 0 || result == false) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

}
