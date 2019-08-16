package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS {

	private static List<Integer>[] graph;

	private static boolean[] visitYn;

	private static Deque<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int vertexCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		int startVertex = Integer.parseInt(st.nextToken());
		graph = new ArrayList[vertexCnt + 1];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[first].add(second);
			graph[second].add(first);
		}
		for (int i = 1; i <= vertexCnt; i++)
			Collections.sort(graph[i]);

		visitYn = new boolean[vertexCnt + 1];
		dfs(startVertex);
		System.out.println();
		visitYn = new boolean[vertexCnt + 1];
		queue = new ArrayDeque<>();
		bfs(startVertex);
	}

	private static void dfs(int now) {
		System.out.print(now + " ");
		visitYn[now] = true;
		for (int i = 0, len = graph[now].size(); i < len; i++) {
			int to = graph[now].get(i);
			if (!visitYn[to]) dfs(to);
		}
	}

	private static void bfs(int now) {
		visitYn[now] = true;
		queue.offerLast(now);
		System.out.print(now + " ");

		while(queue.size() > 0) {
			now = queue.pollFirst();
			for (int i = 0, len = graph[now].size(); i < len; i++) {
				int to = graph[now].get(i);
				if (!visitYn[to]) {
					visitYn[to] = true;
					queue.offerLast(to);
					System.out.print(to + " ");
				}
			}
		}
	}

}
