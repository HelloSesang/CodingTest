package leetcode;

import java.util.Arrays;

public class P344_Reverse_String {

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		char temp = ' ';
		while (left <= right) {
			temp = s[left];
			s[left] = s[right];
			s[right] = temp;

			left++;
			right--;
		}

		System.out.println(Arrays.toString(s));
	}

}
