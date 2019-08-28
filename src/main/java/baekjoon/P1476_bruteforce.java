package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1476_bruteforce {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int e = 1, s = 1, m = 1;
		int i = 0;
		while (true) {
			i++;
			if (e == input[0] && s == input[1] && m == input[2]) break;
			e = e + 1 > 15 ? 1 : e + 1;
			s = s + 1 > 28 ? 1 : s + 1;
			m = m + 1 > 19 ? 1 : m + 1;
		}
		System.out.println(i);
	}

}
