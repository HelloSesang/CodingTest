package baekjoon;

//	L개의 알파벳 소문자로 된 암호
//	사용 가능성이 있는 문자 C가지
//	암호의 문자들은 오름차순 정렬된 상태이다.
//	암호는 최소 한 개의 모음과 최소 두 개의 자음이 포함되어야 한다.
//	암호가 될 수 있는 문자열을 모두 출력하라.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1759_암호만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int L = input[0];
		int C = input[1];

		// 사용 가능한 문자 배열
		String[] characters = br.readLine().split(" ");

		// 문자 배열 정렬
		Arrays.sort(characters);

		// 모든 경우의 수 재귀로 처리
		recursive("", 0, characters, L);
	}

	public static void recursive(String nowPassword, int nowIndex, String[] characters, int targetLength) {
		// 길이가 목표 길이에 도달한 경우
		if (nowPassword.length() == targetLength) {
			// 최소 자음, 모음 조건을 충족하는 경우
			if (checkCandidate(nowPassword)) {
				// 출력한다.
				System.out.println(nowPassword);
			}
			// 종료한다.
			return;
		}

		// 길이가 목표 길이에 도달하지 못한 경우
		// 더 이상 문자를 추가할 수 없는 경우
		if (nowIndex >= characters.length) {
			// 종료한다.
			return;
		}

		// 문자를 추가할 수 있는 경우
		// 현재 인덱스의 문자를 사용하는 경우의 수 처리
		recursive(nowPassword + characters[nowIndex], nowIndex + 1, characters, targetLength);
		// 현재 인덱스의 문자를 사용하지 않는 경우의 수 처리
		recursive(nowPassword, nowIndex + 1, characters, targetLength);
	}

	// 최소 자음, 최소 모음 갯수를 만족하는지 체크하는 메소드
	public static boolean checkCandidate(String candidate) {
		// 변수 선언
		int vowelCount = 0;
		int consonantCount = 0;

		// 암호의 후보 문자열의 각 문자에 순차접근
		for (int i = 0, len = candidate.length(); i < len; i++) {
			// 현재 문자
			char now = candidate.charAt(i);

			// 모음인 경우
			if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
				// 모음 수 카운팅
				vowelCount++;
			// 자음인 경우
			} else {
				// 자음 수 카운팅
				consonantCount++;
			}
		}

		// 조건 만족 여부 반환
		return vowelCount >= 1 && consonantCount >= 2;
	}

}