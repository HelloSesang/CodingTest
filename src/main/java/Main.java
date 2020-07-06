class Solution {
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

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Solution solution = new Solution();
        solution.runningSum(arr);
    }
}