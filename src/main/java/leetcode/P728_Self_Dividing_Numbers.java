package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P728_Self_Dividing_Numbers {

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> answer = new ArrayList<>();

		// left에서 right까지의 수에 순차접근
		for (int i = left; i <= right; i++) {
			// 현재 접근한 수가 SelfDividingNumber인지 체크한다.
			if (checkSelfDivisible(i)) {
				//SelfDividingNumber라면 리스트에 추가한다.
				answer.add(i);
			}
		}

		// 최종 결과를 반환한다.
		return answer;
	}

	// SelfDividingNumber인지 확인하는 메서드
	private boolean checkSelfDivisible(int number) {
		boolean result = true;
		int temp = number;

		while (temp > 0) {
			// 가장 낮은 자릿수를 구한다.
			int rest = temp % 10;
			// 처리한 자릿수를 제외시킨다.
			temp /= 10;
			// 자릿수가 0이거나 자릿수로 나눴을 때 나누어 떨어지지 않는 경우
			if (rest == 0 || number % rest != 0) {
				// SelfDividingNumber가 아니다.
				result = false;
				break;
			}
		}

		// SelfDividingNumber 여부를 반환한다.
		return result;
	}

}
