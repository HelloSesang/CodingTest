package inflearn.chapter1;

import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String[] words = input1.split(" ");
        int index = 0;
        int length = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > length) {
                index = i;
                length = words[i].length();
            }
        }

        System.out.println(words[index]);
    }
}
