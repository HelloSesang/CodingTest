package leetcode;

import java.util.Arrays;

public class P496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] position = new int[nums1.length];
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int i = 0, len = nums1.length; i < len; i++) {
            for (int j = 0, len2 = nums2.length; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    position[i] = j;
                    break;
                }
            }
        }

        for (int i = 0, len = nums1.length; i < len; i++) {
            for (int j = position[i], len2 = nums2.length; j < len2; j++) {
                if (nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }
    
}
