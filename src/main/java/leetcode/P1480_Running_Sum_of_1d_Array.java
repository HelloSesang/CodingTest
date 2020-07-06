package leetcode;

public class P1480_Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int sum = 0;
            if (i != 0) {
                sum += result[i - 1];
            }
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }
}
