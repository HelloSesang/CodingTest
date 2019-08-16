package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1707_BipartiteGraph {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static List<Integer>[] graph;

	private static Status[] statuses;

	private enum Status {
		YET, FIRST, SECOND
	}

	public static void main(String[] args) throws Exception {
		int count = Integer.parseInt(br.readLine());
		while (count-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int vertextCnt = Integer.parseInt(st.nextToken());
			int edgeCnt = Integer.parseInt(st.nextToken());
			boolean result = true;
			buildGraph(vertextCnt, edgeCnt);
			buildStatusArray(vertextCnt);
			// 1번 정점에서 시작하는 DFS로만 처리하면 안된다.
			// 연결요소가 존재하는(그래프가 여러 부분으로 분리되어 있는 경우) 경우
			// 1번 정점과 연결되지 않은 연결 요소가 이분 그래프 요건을 충족시키지 못할수도 있다.
			// 또한 어떤 정점 간에 간선이 아예 없는 경우도 이분 그래프의 요건을 충족시킨다는 것을 알아둬야한다.
			for(int i = 1; i <= vertextCnt; i++) {
				if (statuses[i] == Status.YET) {
					buildStatusArray(vertextCnt);
					result = dfs(i, Status.FIRST);
				}
				if (!result) break;
			}
			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void buildGraph(int vertextCnt, int edgeCnt) throws Exception {
		graph = new ArrayList[vertextCnt + 1];
		for (int i = 1; i <= vertextCnt; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edgeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[first].add(second);
			graph[second].add(first);
		}
	}

	private static void buildStatusArray(int vertextCnt) {
		statuses = new Status[vertextCnt + 1];
		Arrays.fill(statuses, Status.YET);
	}

	private static boolean dfs(int now, Status status) {
		statuses[now] = status;
		status = status == Status.FIRST ? Status.SECOND : Status.FIRST;
		// 1. 다음 정점이 존재한다.
		for (int i = 0, len = graph[now].size(); i < len; i++) {
			int next = graph[now].get(i);
			// 1. 다음 정점이 방문하지 않은 곳이다.
				// 1. 다음 정점으로 이동한다.
					// 1. 다음 정점의 처리 결과가 true 이다.
						// 그대로 넘어간다.
					// 2. 다음 정점의 처리 결과가 false 이다.
						// false를 반환한다.
			// 2. 다음 정점이 방문한 곳이다.
				// 1. 현재 정점과 다음 정점이 같은 색이다.
					// false를 반환한다.
				// 2. 현재 정점과 다음 정점이 다른 색이다.
					// 그대로 넘어간다.

			if (statuses[next] == Status.YET) {
				boolean result = dfs(next, status);
				if (!result) return result;
			} else if (statuses[now] == statuses[next]) {
				return false;
			}
		}
		// 1. 다음 정점이 존재하지 않는다.
			// 1. 정상이므로 ture를 반환한다.
		return true;
	}

}