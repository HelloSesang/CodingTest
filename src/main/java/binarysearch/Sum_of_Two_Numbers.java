package binarysearch;

import java.util.Arrays;

public class Sum_of_Two_Numbers {

    public boolean solve(int[] nums, int k) {
        Arrays.sort(nums);

        int minIdx = 0;
        int maxIdx = nums.length - 1;

        while (minIdx < maxIdx) {
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
