package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int gameCount = in.nextInt();
        in.nextLine();
        int[] userA = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        int[] userB = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();

        for (int i = 0; i < gameCount; i++) {
            int inputA = userA[i];
            int inputB = userB[i];

            if (inputA == inputB) {
                System.out.println("D");
                continue;
            }

            switch (inputA) {
                case 1:
                    if (inputB == 2) {
                        System.out.println("B");
                    } else if (inputB == 3) {
                        System.out.println("A");
                    }
                    break;
                case 2:
                    if (inputB == 1) {
                        System.out.println("A");
                    } else if (inputB == 3) {
                        System.out.println("B");
                    }
                    break;
                case 3:
                    if (inputB == 1) {
                        System.out.println("B");
                    } else if (inputB == 2) {
                        System.out.println("A");
                    }
                    break;
            }
        }
    }
}
