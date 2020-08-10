package leetcode;

public class P1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

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
