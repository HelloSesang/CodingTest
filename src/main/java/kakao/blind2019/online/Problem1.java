// 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여
// 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

package kakao.blind2019.online;

public class Problem1 {

	public static void main(String[] args) {
		Problem1 solution = new Problem1();
		System.out.println(solution.solution("xababcdcdababcdcd"));
	}

	public int solution(String s) {
		if (s.length() <= 1) {
			return s.length();
		}

		int answer = 0;
		for (int i = 1, len = s.length() / 2; i <= len; i++) {
			String result = getCompressedStr(s, i);
			if (answer == 0 || answer > result.length()) {
				answer = result.length();
			}
		}
		return answer;
	}

	private String getCompressedStr(String str, int unit) {
		StringBuilder compressedStr = new StringBuilder();

		String now = "";
		int repeatCount = 0;
		for (int i = 0, len = str.length(); i < len; i += unit) {
			now = str.substring(i, i + unit);
			repeatCount++;

			String next = "";
			if (i + (unit * 2) > len) {
				next = str.substring(i + unit);
				if (now.equals(next)) {
					repeatCount++;
					compressedStr.append(repeatCount).append(now);
				} else {
					if (repeatCount > 1) {
						compressedStr.append(repeatCount);
					}
					compressedStr.append(now).append(next);
				}
				break;
			} else {
				next = str.substring(i + unit, i + (unit * 2));
				if (!now.equals(next)) {
					if (repeatCount > 1) {
						compressedStr.append(repeatCount);
					}
					compressedStr.append(now);
					repeatCount = 0;
				}
			}
		}
		return compressedStr.toString();
	}

}