package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10451_permutation {

	private static int[] graph;

	private static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			setGraph(n, input);
			int result = getPermutationCount(n);
			System.out.println(result);
		}
	}

	private static void setGraph(int count, String[] input) {
		graph = new int[count + 1];
		check = new boolean[count + 1];
		for (int i = 1; i <= count; i++)
			graph[i] = Integer.parseInt(input[i - 1]);
	}

	private static int getPermutationCount(int count) {
		int result = 0;
		for (int i = 1; i <= count; i++) {
			if (check[i] == false) {
				result++;
				dfs(i);
			}
		}
		return result;
	}

	private static void dfs(int now) {
		check[now] = true;
		int next = graph[now];
		if (check[next] == false)
			dfs(next);
	}

}
