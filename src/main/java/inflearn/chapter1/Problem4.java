package inflearn.chapter1;

import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int wordCount = in.nextInt();
        in.nextLine();
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = in.nextLine();
        }

        for (int i = 0; i < wordCount; i++) {
            char[] word = words[i].toCharArray();
            for (int j = word.length - 1; j >= 0; j--) {
                System.out.print(word[j]);
            }
            System.out.println();
        }
    }

}
