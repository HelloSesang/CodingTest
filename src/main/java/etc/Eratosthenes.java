package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Eratosthenes {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[max + 1];
		Arrays.fill(arr, false);

		for (int i = 2; i <= max; i++) {
			if (arr[i] == false) {
				if (i >= min && i <= max) System.out.println(i);
				for (int j = i + i; j <= max; j += i)
					arr[j] = true;
			}
		}
	}

}
