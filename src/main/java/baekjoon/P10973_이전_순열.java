package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10973_이전_순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] permutation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean result = prevPermutation(permutation);

		if (!result) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(permutation[i]);
			if (i + 1 < n) {
				System.out.print(" ");
			}
		}
	}

	private static boolean prevPermutation(int[] sequence) {
		int i = sequence.length - 1;

		// 이전 순열을 만들기 위해 교체해야 할 첫 번째 위치를 찾는다.
		while (i > 0 && sequence[i-1] <= sequence[i]) {
			i--;
		}

		// 마지막 순열에 도달했다는 것으로 더 이상의 다음 순열이 없음을 알린다.
		if (i <= 0) {
			return false;
		}

		// 이전 순열을 만들기 위해 교체해야 할 두 번째 위치를 찾는다.
		int j = sequence.length-1;
		while (sequence[j] >= sequence[i-1]) {
			j--;
		}

		// 찾는 두 위치의 값을 서로 교환한다.
		int temp = sequence[i-1];
		sequence[i-1] = sequence[j];
		sequence[j] = temp;

		// 뒷자리를 오름차순 정렬해서 이전 순열을 완성한다.
		j = sequence.length - 1;
		while (i < j) {
			temp = sequence[i];
			sequence[i] = sequence[j];
			sequence[j] = temp;
			i++;
			j--;
		}
		return true;
	}

}
