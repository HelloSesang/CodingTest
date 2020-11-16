import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		solution.reverseString(s);
	}

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