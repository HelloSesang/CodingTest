package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724_graph {

	private static List<Integer>[] graph;

	private static boolean[] checkArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int vertexCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());

		graph = new ArrayList[vertexCnt + 1];
		for (int i = 1; i < vertexCnt + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[first].add(second);
			graph[second].add(first);
		}

		checkArr = new boolean[vertexCnt + 1];
		int result = 0;
		for(int i = 1; i < vertexCnt + 1; i++) {
			if (!checkArr[i]) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}

	private static void dfs(int start) {
		checkArr[start] = true;
		for (int i = 0, len = graph[start].size(); i < len; i++) {
			int next = graph[start].get(i);
			if (!checkArr[next]) {
				dfs(next);
			}
		}
	}

}
