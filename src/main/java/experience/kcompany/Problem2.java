package experience.kcompany;

import java.util.*;

public class Problem2 {

	public static void main(String[] args) {
		List<String> s = Arrays.asList("abaa", "abc", "kkleejjjj", "", "");
		List<String> t = Arrays.asList("bbbb", "abcd", "krjeldjfs", "", "");
		List<String> answer = areAlmostEquivalent(s, t);
		System.out.println(answer);
	}

	public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
		// 정답을 담을 리스트
		List<String> answer = new ArrayList<>();

		// 리스트 s와 t의 각 요소에 순차접근한다.
		for (int i = 0, len = s.size(); i < len; i++) {
			// s와 t의 문자열을 비교한다.
			answer.add(equivalentCompare(s.get(i), t.get(i)));
		}
		return answer;
	}

	public static String equivalentCompare(String s, String t) {
		String answer = "YES";

		// 길이가 다른 경우 바로 처리한다.
		if (s.length() != t.length()) {
			return "NO";
		}

		// 문자 정보를 담을 Map 자료구조를 생성
		Map<Character, CharInfo> hashMap = new HashMap<>();

		// s문자열의 각 문자에 순차접근한다.
		for (char ch : s.toCharArray()) {
			CharInfo charInfo = hashMap.get(ch);

			// 해당 문자가 처음인 경우
			if (charInfo == null) {
				// 문자 출현 횟수를 설정해서 객체를 생성한다.
				charInfo = new CharInfo(1, 0);
				// map에 문자정보 객체를 저장한다.
				hashMap.put(ch, charInfo);
				// 해당 문자가 처음이 아닌 경우
			} else {
				// 문자 출현 횟수를 카운팅해준다.
				charInfo.countInS += 1;
			}
		}

		// t 문자열의 각 문자에 순차접근한다.
		for (char ch : t.toCharArray()) {
			CharInfo charInfo = hashMap.get(ch);

			// 해당 문자가 처음인 경우
			if (charInfo == null) {
				// 문자 출현 횟수를 설정해서 객체를 생성한다.
				charInfo = new CharInfo(0, 1);
				// map에 문자정보 객체를 저장한다.
				hashMap.put(ch, charInfo);
				// 해당 문자가 처음이 아닌 경우
			} else {
				// 문자 출현 횟수를 카운팅해준다.
				charInfo.countInT += 1;
			}
		}

		// 모든 문자에 대해 gap을 확인해서 3을 초과해서 차이가 나는지 확인
		for (Character ch : hashMap.keySet()) {
			CharInfo charInfo = hashMap.get(ch);
			int gap = Math.abs(charInfo.countInS - charInfo.countInT);
			if (gap > 3) {
				answer = "NO";
				break;
			}
		}

		// 결과를 반환
		return answer;
	}

	static class CharInfo {
		public int countInS;
		public int countInT;

		public CharInfo(int countInS, int countInT) {
			this.countInS = countInS;
			this.countInT = countInT;
		}
	}

}
