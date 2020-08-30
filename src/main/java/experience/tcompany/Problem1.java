package experience.tcompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem1 {

    public static List<Stack<Integer>> doDo() {
        final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);

        List<Stack<Integer>> result = new ArrayList<>();

        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0, len = elements.size(); i < len; i++) {
            int now = elements.get(i);
            sum += now;
            stack.add(now);
            if (i + 1 == len || sum + elements.get(i + 1) > 20) {
                result.add(stack);
                sum = 0;
                stack = new Stack<>();
            }
        }

        return result;
    }

    public static void main(String... args) {
        List<Stack<Integer>> stackList = doDo();
        for (Stack<Integer> stack : stackList) {
            for (Integer element : stack) {
                System.out.print(element.toString());
            }
            System.out.println();
        }
    }
}
