package inflearn;

import java.util.Locale;
import java.util.Scanner;

public class Problem8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.toLowerCase();

        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            char before = input.charAt(i);
            char after = input.charAt(j);

            if (!Character.isAlphabetic(before) || !Character.isAlphabetic(after)) {
                if (!Character.isAlphabetic(before)) {
                    j++;
                } else {
                    i--;
                }

                continue;
            }

            if (before != after) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
