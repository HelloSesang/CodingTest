import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(42));
    }

    public boolean solve(int num) {
        String numStr = String.valueOf(num);
        int end = numStr.length() - 1;
        int midIdx = numStr.length() / 2;

        for (int start = 0; start < midIdx; start++, end--) {
            if (numStr.charAt(start) != numStr.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
