package kakao.blind2019;// 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여
// 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

public class Problem1 {

	public static void main(String[] args) {
		Problem1 solution = new Problem1();
		System.out.println(solution.solution("a"));
	}

	public int solution(String s) {
		int answer = 0;

		for (int i = 1, len = s.length() / 2 + 1; i <= len; i++) {
			int length = compressString(s, i);
			if (answer == 0 || answer > length) {
				answer = length;
			}
		}
		return answer;
	}

	private int compressString(String str, int length) {
		String now = "";
		int repeatCnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = str.length(); i < len; i += length) {
			if (i + length >= str.length()) {
				if (!now.equals(str.substring(i))) {
					if (repeatCnt > 1) sb.append(repeatCnt);
					sb.append(now);
					sb.append(str.substring(i));
				} else {
					sb.append(repeatCnt + 1);
					sb.append(now);
				}
				break;
			}
			String next = str.substring(i, i + length);
			if (!now.equals(next)) {
				if (repeatCnt > 1) sb.append(repeatCnt);
				sb.append(now);
				now = next;
				repeatCnt = 1;
			} else {
				repeatCnt++;
			}
		}
		return sb.toString().length();
	}
}