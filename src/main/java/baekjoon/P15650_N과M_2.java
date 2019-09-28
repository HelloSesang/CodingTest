package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P15650_N과M_2 {

	static int[] sequence;

	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		// 1부터 n까지 자연수가 존재
		int n = Integer.parseInt(input[0]);
		// m개를 골라야한다.
		int m = Integer.parseInt(input[1]);

		// 숫자가 이미 사용됐는지 체크하는 배열
		check = new boolean[n + 1];

		// 완성된 수열이 담기는 배열
		sequence = new int[m];

		// 수열의 첫 번째 자리에 대한 작업을 수
		recursive(0, n, m);
	}

	private static void recursive(int index, int end, int length) {
		// 수열이 완성되면 출력하고 리턴
		if (index >= length) {
			for (int i = 0; i < sequence.length; i++) {
				System.out.print(sequence[i]);
				if (i + 1 < sequence.length) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}

		// 오름차순으로 정렬된 순열만 출력하기 위해 이전 자릿수의 값보다 큰 값부터 for문에서 처리하도록 설정
		int startIdx = index > 0 ? sequence[index - 1] + 1 : 1;

		// 현재 recursive가 처리하는 자릿수에 모든 값을 넣는 작업을 수행
		for (int i = startIdx; i <= end; i++) {
			if (check[i]) {
				continue;
			}

			sequence[index] = i;
			check[i] = true;
			// index + 1번째 자리에 대한 작업을 수행
			recursive(index + 1, end, length);
			check[i] = false;
		}
	}

}
