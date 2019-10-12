package experience.st2;

public class Problem1 {

	public int[] solution(int N) {
		int[] answer = new int[2];

		// 2~9에 순차접근한다.
		for (int i = 2; i < 10; i++) {
			// 현재 접근한 숫자 진법으로 N을 변환한다.
			String convertResult = convert(N, i);

			// 변환한 수의 자릿수 곱을 구한다.
			int multiResult = 1;
			for (int j = 0, len = convertResult.length(); j < len; j++) {
				int cipher = Character.getNumericValue(convertResult.charAt(j));
				if (cipher != 0) {
					multiResult *= cipher;
				}
			}
			// 자릿수 곱이 answer[1]의 값보다 크거나 같은 경우
			if (multiResult >= answer[1]) {
				// answer[0]에 현재 진법을 넣는다.
				answer[0] = i;
				// answer[1]에 현재 자릿수 곱을 넣는다.
				answer[1] = multiResult;
			}
		}

		// 최종 결과를 반환한다.
		return answer;
	}

	private String convert(int target, int convertNum) {
		StringBuilder sb = new StringBuilder();
		while (target > 0) {
			sb.insert(0, target % convertNum);
			target /= convertNum;
		}

		return sb.toString();
	}
}
