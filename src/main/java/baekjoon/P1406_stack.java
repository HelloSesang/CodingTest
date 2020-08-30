package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P1406_stack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> before = new ArrayDeque<>();
        Deque<Character> after = new ArrayDeque<>();
        String init = br.readLine();
        for (int i = 0, len = init.length(); i < len; i++) {
            before.offerLast(init.charAt(i));
        }
        int commandCount = Integer.parseInt(br.readLine());
        while (commandCount-- > 0) {
            String command = br.readLine();
            if (command.startsWith("L") && before.size() != 0) {
                after.offerFirst(before.pollLast());
            }
            if (command.startsWith("D") && after.size() != 0) {
                before.offerLast(after.pollFirst());
            }
            if (command.startsWith("B") && before.size() != 0) {
                before.pollLast();
            }
            if (command.startsWith("P")) {
                before.offerLast(command.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        before.stream().forEach(sb::append);
        after.stream().forEach(sb::append);
        System.out.println(sb.toString());
    }

}
