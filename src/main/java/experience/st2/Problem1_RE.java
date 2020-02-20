package experience.st2;

import java.util.Arrays;

public class Problem1_RE {

    private static final int START = 2;
    private static final int END = 9;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(14)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[2];

        for (int i = START; i <= END; i++) {
            String result = changeNumber(i, n);
            int max = getMaxNumber(result);
            if (max >= answer[1]) {
                answer[0] = i;
                answer[1] = max;
            }
        }
        return answer;
    }

    public static String changeNumber(int i, int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.insert(0, n % i);
            n /= i;
        }

        return sb.toString();
    }

    public static int getMaxNumber(String number) {
        int result = 1;
        for (int i = 0, len = number.length(); i < len; i++) {
            int now = Character.getNumericValue(number.charAt(i));
            if (now != 0) {
                result *= now;
            }
        }

        return result;
    }

}
