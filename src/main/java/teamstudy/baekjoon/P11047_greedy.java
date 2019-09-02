package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_greedy {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int tokenCount = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());

		int[] token = new int[tokenCount];
		for (int i = 0; i < tokenCount; i++) {
			token[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		for (int i = tokenCount - 1; i >= 0; i--) {
			if (total >= token[i]) {
				answer += total / token[i];
				total = total % token[i];
			}
		}
		System.out.println(answer);
	}

}
