package inflearn.chapter1;

import java.util.Scanner;

public class Problem6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        StringBuilder result = new StringBuilder();

        char[] chars = input.toCharArray();
        boolean[] isDuplicated = new boolean[chars.length];
        for (int i = 0; i < input.length(); i++) {
            if (isDuplicated[i]) continue;
            result.append(chars[i]);

            for (int j = i + 1; j < input.length(); j++) {
                char base = chars[i];
                if (base == chars[j]) {
                    isDuplicated[j] = true;
                }
            }
        }

        System.out.println(result);
    }
}
