package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentCount = in.nextInt();
        in.nextLine();
        int[] studentHeights = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();

        int result = 0;
        int biggestHeightUntilNow = 0;
        for (int height: studentHeights) {
            if (isBiggestHeight(height, biggestHeightUntilNow)) {
                result++;
                biggestHeightUntilNow = height;
            }
        }
        System.out.println(result);
    }

    private static boolean isBiggestHeight(int height, int biggestHeightUntilNow) {
        return height > biggestHeightUntilNow;
    }
}
