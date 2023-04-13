package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        int[] numbers = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            if (isBiggerThanBeforeNumber(numbers, i)) {
                System.out.print(numbers[i]);
                System.out.print(" ");
            }
        }
    }

    private static boolean isBiggerThanBeforeNumber(int[] numbers, int index) {
        if (index == 0) {
            return true;
        }

        if (numbers[index] <= numbers[index - 1]) {
            return false;
        }
        return true;
    }
}
