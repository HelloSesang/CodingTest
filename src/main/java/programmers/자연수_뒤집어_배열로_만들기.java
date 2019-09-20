package programmers;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

	public static void main(String[] args) {
		자연수_뒤집어_배열로_만들기 obj = new 자연수_뒤집어_배열로_만들기();
		int[] answer = obj.solution(10000000000L);
		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(long n) {
		long temp = n;
		int length = 0;

		while (temp != 0) {
			length++;
			temp /= 10;
		}

		int[] answer = new int[length];

		for (int i = 0, len = answer.length; i < len; i++) {
			answer[i] = (int) (n % 10);
			n /= 10;
		}

		return answer;
	}

}
