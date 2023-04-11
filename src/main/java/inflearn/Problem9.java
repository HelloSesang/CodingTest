package inflearn;

import java.util.Scanner;

public class Problem9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)) {
                result.append(current);
            }
        }
        System.out.println(Integer.parseInt(result.toString()));
    }
}
