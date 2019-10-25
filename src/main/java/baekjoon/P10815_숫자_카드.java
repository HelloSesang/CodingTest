package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10815_숫자_카드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cardCount = Integer.parseInt(br.readLine());
		int[] cardList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int targetCount = Integer.parseInt(br.readLine());
		int[] targetList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// cardList를 오름차순 정렬한다.
		Arrays.sort(cardList);

		int[] answer = new int[targetCount];

		// targetList에 순차접근한다.
		for (int i = 0, len = targetList.length; i < len; i++) {
			// cardList에 현재 접근한 요소가 존재하는지 확인한다.
			answer[i] = binarySearch(targetList[i], cardList);
		}

		// 최종 결과를 반환한다.
		for (int num : answer) {
			System.out.print(num + " ");
		}
	}

	private static int binarySearch(int target, int[] cardList) {
		int left = 0;
		int right = cardList.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			// 존재하는 경우
			if (cardList[mid] == target) {
				return 1;
			}
			// target 보다 큰 수인 경우
			if (cardList[mid] > target) {
				right = mid - 1;
			}
			// target 보다 작은 수인 경우
			if (cardList[mid] < target) {
				left = mid + 1;
			}
		}

		// 존재하지 않는 경우
		return 0;
	}

}
