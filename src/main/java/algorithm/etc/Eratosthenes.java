package algorithm.etc;

import java.util.Arrays;
import java.util.Scanner;

public class Eratosthenes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxNumber = in.nextInt();

        System.out.println(Eratosthenes.solution(maxNumber));
    }

    private static int solution(int maxNumber) {
        int primeNumberCount = 0;

        boolean[] primeNumberCheckingArray = new boolean[maxNumber + 1];
        Arrays.fill(primeNumberCheckingArray, true);

        for (int currentNumber = 2; currentNumber <= maxNumber; currentNumber++) {
            if (primeNumberCheckingArray[currentNumber] == false) {
                continue;
            }
            primeNumberCount++;
            checkNonPrimeNumber(primeNumberCheckingArray, currentNumber);
        }
        return primeNumberCount;
    }

    private static void checkNonPrimeNumber(boolean[] primeNumberCheckingArray, int currentNumber) {
        for (int i = currentNumber; i < primeNumberCheckingArray.length; i = i + currentNumber) {
            primeNumberCheckingArray[i] = false;
        }
    }
}
