package programmers;

public class P124_나라의_숫자 {

	public String solution(int n) {
		return convertNumber(n);
	}

	private String convertNumber(int n) {
		StringBuilder sb = new StringBuilder();

		while (n != 0) {
			// 하나의 자릿수를 결정할 10진수를 구한다.
			int remainder = n % 3;

			// 결과로 나온 10진수 값에 근거해서 자릿수를 하나 완성한다.
			switch (remainder) {
				case 0 : sb.insert(0, 4);
					break;
				case 1 : sb.insert(0, 1);
					break;
				case 2 : sb.insert(0, 2);
					break;
			}

			// 이미 처리한 자릿수는 제외한다.
			n /= 3;

			// remainder가 0인 경우 이미 처리된 수가 다음 n에 포함되어 버리므로 n - 1을 한다.
			if (remainder == 0) {
				n -= 1;
			}
		}

		// 진법 변환 결과를 반환한다.
		return sb.toString();
	}

}
