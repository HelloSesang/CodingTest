package binarysearch;

public class P3_6_9 {

    public String[] solve(int n) {
        String[] result = new String[n];
        for (int i = 1; i <= n; i++) {
            if (checkCondition(i)) {
                result[i - 1] = "clap";
            } else {
                result[i - 1] = String.valueOf(i);
            }
        }
        return result;
    }

    private boolean checkCondition(int num) {
        if (num % 3 == 0) {
            return true;
        }

        for (char ch : String.valueOf(num).toCharArray()) {
            if (ch == '3' || ch == '6' || ch == '9') {
                return true;
            }
        }
        return false;
    }
    
}
