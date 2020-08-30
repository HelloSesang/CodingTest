package kakao.blind2017.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapLen = Integer.parseInt(br.readLine());
        int[] firstMap = {46, 33, 33, 22, 31, 50};
        int[] secondMap = {27, 56, 19, 14, 14, 10};
        String[] answer = new String[mapLen];

        for (int i = 0; i < mapLen; i++) {
            String line = changeDecimalToBinaryStr(firstMap[i] | secondMap[i], mapLen);
            StringBuilder sb = new StringBuilder();
            for (int j = 0, len = line.length(); j < len; j++) {
                if (line.charAt(j) == '0') {
                    sb.append(" ");
                }
                if (line.charAt(j) == '1') {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        for (String e : answer) {
            System.out.println(e);
        }
    }

    private static String changeDecimalToBinaryStr(int decimal, int length) {
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            sb.insert(0, decimal % 2);
            decimal /= 2;
        }
        while (sb.length() < length)
            sb.insert(0, "0");
        return sb.toString();
    }

}
