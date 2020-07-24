import java.util.*;


class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {10, 36, 22, 14};
        int k = 4;

        System.out.println(solution.solve(nums, k));
    }

    public boolean solve(int[] nums, int k) {
        Arrays.sort(nums);
        int minIdx = 0;
        int maxIdx = nums.length - 1;

        while(minIdx < maxIdx) {
            int sum = nums[minIdx] + nums[maxIdx];
            if (sum == k) {
                return true;
            } else if (sum < k) {
                minIdx++;
            } else if (sum > k) {
                maxIdx--;
            }
        }
        return false;
    }
}