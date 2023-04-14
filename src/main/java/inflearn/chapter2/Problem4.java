package inflearn.chapter2;

import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int progressionLength = in.nextInt();

        int beforebefore = 0;
        int before = 0;
        for (int i = 0; i < progressionLength; i++) {
            if (i == 0) {
                before = 1;
                System.out.print(1);
                System.out.print(" ");
                continue;
            }
            int current = beforebefore + before;
            beforebefore = before;
            before = current;
            System.out.print(current);
            System.out.print(" ");
        }
    }
}
