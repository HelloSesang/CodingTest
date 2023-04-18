package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberCount = in.nextInt();
        in.nextLine();
        Arrays.stream(in.nextLine().split(" "))
                .mapToInt(value -> {
                    int number = Integer.parseInt(value);
                    return reverseNumber(number);
                })
                .forEach(value -> {
                    if (isPrimeNumber(value)) {
                        System.out.print(value);
                        System.out.print(" ");
                    }
                });
    }

    private static boolean isPrimeNumber(int targetNumber) {
        if (targetNumber == 1) {
            return false;
        }
        // desc: i * i가 targetNumber보다 작거나 같아야한다는 조건이 루트 targetNumber까지만 체크하겠다는 의미이다.
        for (int i = 2; i * i <= targetNumber; i++) {
            if (targetNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverseNumber(int number) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(number % 10);
            number /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
