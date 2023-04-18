package inflearn.chapter2;

import java.util.Scanner;

public class Problem7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int problemCount = in.nextInt();
        in.nextLine();
        String[] answers = in.nextLine().split(" ");

        int result = 0;
        int repeatCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].equals("0")) {
                repeatCount = 0;
                continue;
            }
            result += repeatCount + 1;
            repeatCount++;
        }
        System.out.println(result);
    }
}
