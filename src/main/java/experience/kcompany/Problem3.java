package experience.kcompany;

import java.util.ArrayDeque;
import java.util.Deque;

/*
	문제)
	주어진 문자열과 반복횟수를 이용해서 문자열을 압축한 결과를 반환하는 문제
	반복횟수만큼 반복되는 문자가 문자열 내 존재하지 않을 때까지 계속해서 문자열을 압축한다.

	해결방법)
	1. 주어진 문자열의 문자에 순차적으로 접근하면서 문자열 스택와 문자 정보 스택에 값을 완성해서 집어넣는다.
	2. 문자 정보 스택의 값에 따라 문자가 k번 반복된 경우 해당 문자를 문자열 스택에서 제거하고 해당 문자의 문자 정보 스택도 제거한다.

	실수한 부분)
	최소한 하나의 문자는 남기도록 해야하는데 그 부분에 대한 조건문 처리가 잘못됐다.
	더 이상 추가할 문자가 없는 상황에서 문자열 스택을 전부 삭제해야되는 경우에 deleteCount를 하나 줄이도록 만들었어야 한다.
*/

public class Problem3 {

	public static void main(String[] args) {
		String result = compressWord("bbbb", 4);
		System.out.println(result);
	}

	public static String compressWord(String word, int K) {
		// 문자열을 압축하면서 완성해나갈 스택
		Deque<Character> stringStack = new ArrayDeque<>();
		// 문자의 출현횟수 정보를 담는 스택
		Deque<CharInfo> charInfoStack = new ArrayDeque<>();

		// 문자열에 순차 접근한다.
		for (char ch : word.toCharArray()) {
			// 바로 이전에 나타난 문자가 무엇인지 확인
			char top = ' ';
			if (stringStack.size() > 0) {
				top = stringStack.peekLast();
			}
			// 다른 문자가 나타난 경우
			if (top != ch) {
				// 새로나온 문자를 집어넣는다.
				stringStack.offerLast(ch);
				// 문자정보 객체를 생성한다.
				CharInfo charInfo = new CharInfo(ch, 1);
				// 문자정보 스택에 담는다.
				charInfoStack.offerLast(charInfo);
			// 같은 문자가 나타난 경우
			} else {
				// 문자 정보를 찾는다.
				CharInfo charInfo = charInfoStack.peekLast();
				// 동일 문자가 K번 이상 반복된 경우
				if (charInfo.count + 1 >= K) {
					int deleteCount = K - 1;
					// 최소한 문자 1개를 남기기 위한 처리
					// 이 부분 잘못한 것 같다.
					/*if (deleteCount == stringStack.size() && 다음 문자가 없는 경우) {

					}*/
					if (K == word.length()) {
						deleteCount--;
					}
					// 문자 스택에서 K-1개를 제거한다.
					for (int i = 0; i < deleteCount; i++) {
						stringStack.pollLast();
					}
					// 문자정보 스택에서 1개를 제거한다.
					charInfoStack.pollLast();
				// K번 반복되지 않은 경우
				} else {
					// 문자 스택에 문자를 추가한다.
					stringStack.offerLast(ch);
					// 문자정보 객체의 카운트를 1추가한다.
					charInfo.count += 1;
				}
			}
		}
		// 결과 문자열을 만들기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		// 문자 스택이 비어질 때까지 반복
		while (stringStack.size() > 0) {
			// 문자를 하나씩 더해 최종 결과를 만든다.
			sb.insert(0, stringStack.pollLast());
		}
		// 최종 결과를 반환한다.
		return sb.toString();
	}

	static class CharInfo {
		public char ch;
		public int count;

		public CharInfo(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
	}
}
