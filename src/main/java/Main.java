import java.util.*;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 4, 0, 1, 0};

        System.out.println(solution.solve(nums));
    }

    public boolean solve(int[] nums) {
        return recursive(0, nums);
    }

    private boolean recursive(int index, int[] nums) {
        if (nums.length - 1 <= index) {
            return true;
        }

        if (nums[index] <= 0) {
            return false;
        }

        for (int i = nums[index]; i > 0 ; i--) {
            if (recursive(index + i, nums)) {
                return true;
            } else {
                nums[index + i] = 0;
            }
        }

        return false;
    }

}