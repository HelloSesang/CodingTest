package experience.tcompany;

public class Problem2 extends Object {

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println(countBits(7));
    }

    public static int countBits(int number) {
        String result = makeBinary(number);
        int answer = 0;
        for (int i = 0, len = result.length(); i < len; i++) {
            if (result.charAt(i) == '1') {
                answer++;
            }
        }
        return answer;
    }

    private static String makeBinary(int number) {
        final int TYPE = 2;
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.insert(0, number % TYPE);
            number /= TYPE;
        }
        return sb.toString();
    }


}
