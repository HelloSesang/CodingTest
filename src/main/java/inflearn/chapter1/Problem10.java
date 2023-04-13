package inflearn.chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        String input1 = input[0];
        char input2 = input[1].charAt(0);

        int[] result = new int[input1.length()];
        Arrays.fill(result, -1);
        int distance = 0;
        int before = 0;

        for (int i = 0; i < input1.length(); i++) {
            char current = input1.charAt(i);
            if (current == input2) {
                result[i] = 0;
                for (int j = distance; j > 0; j--) {
                    if (result[i - j] == -1 || result[i - j] > j) {
                        result[i - j] = j;
                    }
                }
                before = 1;
                distance = 1;
            } else {
                if (isBeforeExist(before)) {
                    result[i] = before;
                    before++;
                }
                distance++;
            }
        }

        for(int number : result) {
            System.out.print(number);
            System.out.print(" ");
        }
    }

    private static boolean isBeforeExist(int before) {
        return before > 0;
    }
}
