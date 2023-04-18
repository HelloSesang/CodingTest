package kblind.blind2017.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {

    private static int[] points = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] chances = splitChance(input);
        for (int i = 0; i < 3; i++) {
            getPoint(chances[i], i);
        }
        int answer = points[0] + points[1] + points[2];
        System.out.println(answer);
    }

    private static String[] splitChance(String input) {
        String[] result = new String[3];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = input.length(); i < len; i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9' && i != 0 && sb.charAt(sb.length() - 1) != '1') {
                result[index] = sb.toString();
                sb = new StringBuilder();
                index++;
            }
            sb.append(input.charAt(i));
        }
        result[index] = sb.toString();
        return result;
    }

    private static void getPoint(String chance, int count) {
        for (int i = 0, len = chance.length(); i < len; i++) {
            char ch = chance.charAt(i);
            if (ch == 'S' || ch == 'D' || ch == 'T') {
                points[count] = Integer.parseInt(chance.substring(0, i));
                switch (ch) {
                    case 'D':
                        points[count] = (int) Math.pow(points[count], 2);
                        break;
                    case 'T':
                        points[count] = (int) Math.pow(points[count], 3);
                        break;
                }
            } else if (ch == '*') {
                points[count] *= 2;
                if (count != 0) {
                    points[count - 1] *= 2;
                }
            } else if (ch == '#') {
                points[count] *= -1;
            }
        }
    }

}
