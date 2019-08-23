package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309_bruteforce {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] height = new int[9];
		for (int i = 0, len = height.length; i < len; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(height);
		int sum = 0;
		for (int e : height) sum += e;

		for (int i = 0, len = height.length; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (sum - height[i] - height[j] == 100) {
					for (int k = 0; k < len; k++) {
						if (k != i && k != j) {
							System.out.println(height[k]);
						}
					}
					return;
				}
			}
		}
	}

}
