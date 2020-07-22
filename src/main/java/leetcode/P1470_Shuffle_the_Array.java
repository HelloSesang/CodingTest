package leetcode;

public class P1470_Shuffle_the_Array {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            result[count++] = nums[i];
            result[count++] = nums[i + n];
        }
        return result;
    }

}
