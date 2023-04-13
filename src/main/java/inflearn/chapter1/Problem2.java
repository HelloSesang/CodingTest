package inflearn.chapter1;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input1.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            } else {
                ch = Character.toLowerCase(ch);
            }
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);
    }

}
