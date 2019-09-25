package programmers;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

	public int[] solution(int[] arr) {
		if (arr.length <= 1) {
			return new int[]{-1};
		}

		int min = Arrays.stream(arr).min().getAsInt();
		return Arrays.stream(arr).filter(value -> value != min).toArray();
	}

}
