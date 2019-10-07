package baekjoon;

/*
	카잉 달격 6064
	m과 n보다 작거나 같은 두 개의 자연수 x,y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCnt = Integer.parseInt(br.readLine());

		while (testCnt-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int i = 1; ; i++) {

				if ((((input[0] * i) + input[2]) % input[1]) == input[3]) {
					System.out.println((input[0] * i) + input[2]);
					break;
				}
			}
		}
	}

}
