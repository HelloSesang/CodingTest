package inflearn;

import java.util.Locale;
import java.util.Scanner;

public class Problem7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.toLowerCase();

        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
