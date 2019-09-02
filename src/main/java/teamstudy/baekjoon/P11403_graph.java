package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P11403_graph {

	private static BufferedReader br;

	private static List<Integer>[] graph;

	private static int[] check;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int vertexCount = Integer.parseInt(br.readLine());

		setGraph(vertexCount);

		for (int i = 1; i <= vertexCount; i++) {
			for (int j = 1; j <= vertexCount; j++) {
				check = new int[vertexCount + 1];
				System.out.print(getConnection(i, j));
				if (j != vertexCount) System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void setGraph(int vertexCount) throws Exception {
		graph = new ArrayList[vertexCount + 1];
		for (int i = 1; i <= vertexCount; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= vertexCount; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0, len = input.length; j < len; j++) {
				int connectYn = Integer.parseInt(input[j]);
				if (connectYn == 1) {
					graph[i].add(j + 1);
				}
			}
		}
	}

	private static int getConnection(int now, int target) {
		int answer = 0;
		check[now] = 1;
		for (int e : graph[now]) {
			if (e == target) answer = 1;
			if (answer != 1 && check[e] != 1) {
				answer = getConnection(e, target);
			}
			if (answer == 1) break;
		}
		return answer;
	}

}
