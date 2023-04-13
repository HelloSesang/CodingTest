package inflearn.chapter1;

import java.util.Scanner;

public class Problem12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int characterCount = in.nextInt();
        in.nextLine();
        String input = in.nextLine();

        StringBuilder result = new StringBuilder();
        while(characterCount-- > 0) {
            String encryptedCharacter = input.substring(0, 7);
            result.append(decryptCharacter(encryptedCharacter));
            input = input.substring(7);
        }
        System.out.println(result);
    }

    private static char decryptCharacter(String encryptedCharacter) {
        String binary = createBinary(encryptedCharacter);
        int decimalNumber = createDecimalNumber(binary);
        return createASCII(decimalNumber);
    }

    private static String createBinary(String encryptedCharacter) {
        StringBuilder result = new StringBuilder();
        for (char ch : encryptedCharacter.toCharArray()) {
            if (ch == '#') {
                result.append(1);
            } else {
                result.append(0);
            }
        }
        return result.toString();
    }

    private static int createDecimalNumber(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private static char createASCII(int decimalNumber) {
        return (char) decimalNumber;
    }
}
