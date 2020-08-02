package leetcode;

public class P665_Non_decreasing_Array {

    public boolean checkPossibility(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            if (isSorted(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSorted(int[] nums, int excludedIndex) {
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i == excludedIndex) {
                continue;
            }

            int nextIdx = i + 1 == excludedIndex ? i + 2 : i + 1;
            if (nextIdx >= len) {
                break;
            }

            if (nums[i] > nums[nextIdx]) {
                return false;
            }
        }
        return true;
    }

}
