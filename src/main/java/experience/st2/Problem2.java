package experience.st2;

import java.util.Arrays;

public class Problem2 {

	public int solution(int[] v) {
		int answer = 0;

		// 배열 v를 오름차순 정렬한다.
		Arrays.sort(v);

		// 배열 v의 순열을 처음부터 끝까지 만들어간다.
		do {
			int sum = 0;
			// 현재 순열의 요소에 순차접근한다.
			for (int i = 1, len = v.length; i < len; i++) {
				// 현재 순열에서의 계산 값을 구한다.
				sum += Math.abs(v[i-1] - v[i]);
			}
			// 계산 값이 answer보다 큰 경우
			if (answer < sum) {
				// answer에 계산 값을 대입한다.
				answer = sum;
			}
		} while(nextPermutation(v));

		// 최종 결과를 반환한다.
		return answer;
	}

	// 다음 순열을 구하는 메소드
	private static boolean nextPermutation(int[] sequence) {
		int first = sequence.length - 1;

		// 다음 순열을 만들기 위해 교체해야 할 첫 번째 위치를 찾는다.
		while (first > 0 && sequence[first-1] >= sequence[first]) {
			first--;
		}

		// 마지막 순열에 도달했다는 것으로 더 이상의 다음 순열이 없음을 알린다.
		if (first <= 0) {
			return false;
		}

		// 다음 순열을 만들기 위해 교체해야 할 두 번째 위치를 찾는다.
		int second = sequence.length-1;
		while (sequence[second] <= sequence[first-1]) {
			second--;
		}

		// 찾는 두 위치의 값을 서로 교환한다.
		int temp = sequence[first-1];
		sequence[first-1] = sequence[second];
		sequence[second] = temp;

		// 뒷자리를 오름차순 정렬해서 다음 순열을 완성한다.
		second = sequence.length - 1;
		while (first < second) {
			temp = sequence[first];
			sequence[first] = sequence[second];
			sequence[second] = temp;
			first++;
			second--;
		}
		return true;
	}

}
