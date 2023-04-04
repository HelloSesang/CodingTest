package inflearn;

import java.util.Locale;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine().toLowerCase();
        char input2 = in.nextLine().toLowerCase().charAt(0);

        int result = 0;
        for (char ch : input1.toCharArray()) {
            if (ch == input2) {
                result++;
            }
        }
        System.out.println(result);
    }
}
