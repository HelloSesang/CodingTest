import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFSAndBFS {

	private static int vertex;

	private static int edge;

	private static int start;

	private static List<Integer>[] graph;

	private static boolean[] check;

	private static Deque<Integer> queue;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		graph = new ArrayList[vertex + 1];
		queue = new ArrayDeque<Integer>();
		for (int i = 1; i < vertex + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		setGraph();
		check = new boolean[vertex + 1];
		dfs(start);
		System.out.println();
		check = new boolean[vertex + 1];
		bfs(start);
	}

	private static void setGraph() throws Exception{
		for (int i = 1; i < edge + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int pos1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			graph[pos1].add(pos2);
			graph[pos2].add(pos1);
		}
		for (int i = 1, len = graph.length; i < len; i++) {
			Collections.sort(graph[i]);
		}
	}

	private static void dfs(int pos) throws Exception {
		check[pos] = true;
		System.out.print(pos + " ");
		for (int i = 0, len = graph[pos].size(); i < len; i++) {
			int to = graph[pos].get(i);
			if (!check[to]) dfs(to);
		}
	}

	private static void bfs(int pos) throws Exception {
		check[pos] = true;
		queue.offerLast(pos);

		while(!queue.isEmpty()) {
			int now = queue.pollFirst();
			System.out.print(now + " ");
			for (int i = 0, len = graph[now].size(); i < len; i++) {
				int to = graph[now].get(i);
				if (!check[to]) {
					queue.offerLast(to);
					check[to] = true;
				}
			}
		}
	}

}
