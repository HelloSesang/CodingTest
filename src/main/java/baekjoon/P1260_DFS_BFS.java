package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS_BFS {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int vertexCnt;

    private static int edgeCnt;

    private static int startVertex;

    private static List<Integer>[] graph;

    private static Deque<Integer> queue;

    private static int[] visitChecker;

    public static void main(String[] args) throws Exception {
        initGraph();
        setGraph();
        sortGraph();
        visitChecker = new int[vertexCnt + 1];
        dfs(startVertex);
        visitChecker = new int[vertexCnt + 1];
        System.out.println();
        bfs(startVertex);
    }

    private static void initGraph() throws Exception {
        String[] input = br.readLine().split(" ");
        vertexCnt = Integer.parseInt(input[0]);
        edgeCnt = Integer.parseInt(input[1]);
        startVertex = Integer.parseInt(input[2]);
        graph = new List[vertexCnt + 1];
        queue = new ArrayDeque<>();
        for (int i = 1; i <= vertexCnt; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    private static void setGraph() throws Exception {
        for (int i = 1; i <= edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph[first].add(second);
            graph[second].add(first);
        }
    }

    private static void sortGraph() {
        for (int i = 1; i <= vertexCnt; i++) {
            Collections.sort(graph[i]);
        }
    }

    private static void dfs(int now) {
        visitChecker[now] = 1;
        System.out.print(now + " ");
        for (int next : graph[now]) {
            if (visitChecker[next] == 0) {
                dfs(next);
            }
        }
    }

    private static void bfs(int now) {
        visitChecker[now] = 1;
        queue.offerLast(now);
        System.out.print(now + " ");

        while (queue.size() > 0) {
            now = queue.pollFirst();
            for (int next : graph[now]) {
                if (visitChecker[next] == 0) {
                    visitChecker[next] = 1;
                    queue.offerLast(next);
                    System.out.print(next + " ");
                }
            }
        }
    }

}
