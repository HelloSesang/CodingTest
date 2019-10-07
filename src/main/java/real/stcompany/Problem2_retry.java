package real.stcompany;

/*
	String S는 영문 소문자로 이루어져 있다.
	String S의 길이는 2 ~ 300,000이다.
	인접한 두 문자의 조합을 digram 이라고한다.
	두 digram 사이의 거리는 첫 번째 digram의 첫 문자와 두 번째 digram의 첫 문자 사이의 거리이다.
	문자열 S에서 가장 먼 동일 digram의 길이를 구하는 메소드를 작성하라
	동일 digram이 존재하지 않으면  -1을 반환하라
*/

public class Problem2_retry {

	public int solution(String S) {
		// answer 변수를 만들고 -1을 할당한다.
		int answer = -1;

		// 반복문을 이용해서 가장 왼쪽의 digram부터 순차접근한다.
			// 내부 반복문을 이용해서 가장 오른쪽의 digram부터 순차접근한다.(내부 반복문의 index 값은 외부 반복문의 index보다는 커야한다.)
				// 두 digram이 같은 경우
					// 두 digram 사이의 거리가 answer의 값보다 큰 경우 answer에 둘 사이의 거리를 대입한다.
					// break로 현재 digram에서 벗어난다.
				// 두 digram이 다른 경우
					// 한 칸 더 오른쪽의 digram에 접근한다.

		return 0;
	}

}
