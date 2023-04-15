package algorithm.binarysearch;

public class Omitted {

    public int[] solve(int[] nums) {
        int max = 1;
        boolean zeroExist = false;
        int zeroCount = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) {
                zeroExist = true;
                zeroCount++;
                continue;
            }
            max *= nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0, len = result.length; i < len; i++) {
            if (zeroExist) {
                if (zeroCount > 1) {
                    result[i] = 0;
                } else {
                    if (nums[i] == 0) {
                        result[i] = max;
                    } else {
                        result[i] = 0;
                    }
                }
            } else {
                result[i] = max / nums[i];
            }
        }

        return result;
    }

}
