import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(nums)));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                if (nums[i] > nums[j]) {
                    result[i]++;
                }
            }
        }

        return result;
    }

}