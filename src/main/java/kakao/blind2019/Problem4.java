package kakao.blind2019;// 노래 가사에 사용된 단어들 중에 특정 키워드가 몇 개 포함되어 있는지 궁금
// 가사에 사용된 모든 단어들이 담긴 배열 words
// 찾고자 하는 키워드가 담긴 배열 queries

import java.util.Arrays;

public class Problem4 {

	public static void main(String[] args) {
		Problem4 solution = new Problem4();
		String[] arr1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] arr2 = {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(Arrays.toString(solution.solution(arr1, arr2)));
	}

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		for (int i = 0, len = queries.length; i < len; i++) {
			for (String word : words) {
				if (queries[i].length() == word.length() && checkMatching(queries[i], word)) {
					answer[i]++;
				}
			}
		}
		return answer;
	}

	private boolean checkMatching(String query, String word) {
		int start = query.indexOf("?");
		int end = query.lastIndexOf("?");
		boolean result = false;
		if (start == 0 && end == query.length() - 1) {
			// 전체
			result = true;
		} else if (start == 0) {
			// 접두사
			result = query.substring(end + 1).equals(word.substring(end + 1));
		} else {
			// 접미사
			result = query.substring(0, start).equals(word.substring(0, start));
		}
		return result;
	}


}
