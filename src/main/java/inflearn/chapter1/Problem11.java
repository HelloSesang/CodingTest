package inflearn.chapter1;

import java.util.Scanner;

public class Problem11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        StringBuilder result = new StringBuilder();
        int repeatCount = 0;
        char beforeCharacter = ' ';

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (isFirstCharacter(i)) {
                beforeCharacter = current;
                result.append(current);
                repeatCount++;
                continue;
            }

            if (isCharacterRepeated(beforeCharacter, current)) {
                repeatCount++;
                continue;
            }

            if (isThereRepeatHistory(repeatCount)) {
                result.append(repeatCount);
                repeatCount = 1;
            }
            result.append(current);
            beforeCharacter = current;
        }

        if (isThereRepeatHistory(repeatCount)) {
            result.append(repeatCount);
        }

        System.out.println(result);
    }

    private static boolean isThereRepeatHistory(int repeatCount) {
        return repeatCount > 1;
    }

    private static boolean isCharacterRepeated(char beforeCharacter, char current) {
        return current == beforeCharacter;
    }

    private static boolean isFirstCharacter(int i) {
        return i == 0;
    }
}
