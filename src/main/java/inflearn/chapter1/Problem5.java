package inflearn.chapter1;

import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        char[] chars = input.toCharArray();
        char temp;
        int i = 0;
        int j = chars.length - 1;

        while (i < j && j > i) {
            while (!Character.isLetter(chars[i])) {
                i++;
            }
            while (!Character.isLetter(chars[j])) {
                j--;
            }
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        System.out.println(String.valueOf(chars));
    }

}
