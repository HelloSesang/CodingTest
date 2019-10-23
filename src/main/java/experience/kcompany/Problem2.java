package experience.kcompany;

import java.util.*;

/*
	문제)
	두 문자열의 길이가 같고 문자열을 구성하는 각각의 문자의 출현 빈도가
	3회 이상 차이나지 않는 경우 거의 똑같은 문자열이라고 한다.

	주어진 문자열 리스트들이 거의 똑같은 문자열인지 아닌지 'YES' or 'NO'로
	알려주는 리스트를 반환하는 메서드를 완성하라

	해결방법)
	1. 주어진 두 문자열 리스트에 순차접근해서 동일 인덱스에 존재하는 두 문자열을 비교한다.
	2. s 문자열의 각 문자에 순차 접근하면서 그 문자에 대한 정보를 CharInfo 객체에 담는다.
	3. CharInfo 객체를 HashMap에 추가한다.
	4. t 문자열의 각 문자에 순차 접근하면서 그 문자에 대한 정보를 CharInfo 객체에 담는다.
	5. CharInfo 객체를 HashMap에 추가한다.
	6. HashMap을 돌면서 최종적으로 두 문자열을 구성하는 각 문자가 어떤 차이를 가지고 있는지 확인한다.
	7. 조건을 만족하면 'YES' 아니면 'NO'를 리스트에 추가한다.
	8. 최종 완성된 리스트를 반환한다.

*/

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
