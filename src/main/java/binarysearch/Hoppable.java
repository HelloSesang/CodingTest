package binarysearch;

public class Hoppable {

    public boolean solve(int[] nums) {
        return recursive(0, nums);
    }

    private boolean recursive(int index, int[] nums) {
        if (nums.length - 1 <= index) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (recursive(index + i, nums)) {
                return true;
            } else {
                nums[index + i] = 0;
            }
        }

        return false;
    }

}
