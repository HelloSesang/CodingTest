package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS와_BFS {

    private static boolean[] check;
    private static Deque<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 정점 갯수
        int vertexCount = Integer.parseInt(input[0]);
        // 간선 갯수
        int edgeCount = Integer.parseInt(input[1]);
        // 검색 시작 정점
        int startVertex = Integer.parseInt(input[2]);

        // 그래프 자료구조 생성
        List<Integer>[] graph = new ArrayList[vertexCount + 1];
        for (int i = 0, len = graph.length; i < len; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프에 간선 정보 저장
        while (edgeCount-- > 0) {
            String[] edge = br.readLine().split(" ");
            int point1 = Integer.parseInt(edge[0]);
            int point2 = Integer.parseInt(edge[1]);
            graph[point1].add(point2);
            graph[point2].add(point1);
        }

        for (List list : graph) {
            list.sort((Comparator) (o1, o2) -> (Integer) o1 - (Integer) o2);
        }

        check = new boolean[vertexCount + 1];
        dfs(graph, startVertex);

        System.out.println();

        check = new boolean[vertexCount + 1];
        queue = new ArrayDeque<>();
        bfs(graph, startVertex);
    }

    public static void dfs(List<Integer>[] graph, int nowVertex) {
        // 현재 정점에 check
        check[nowVertex] = true;
        // 정점을 출력
        System.out.print(nowVertex + " ");
        // 연결된 간선에 순차접근
        for (int e : graph[nowVertex]) {
            // check가 안된 정점인 경우
            if (!check[e]) {
                // 해당 정점으로 이동
                dfs(graph, e);
            }
        }

        // 모든 연결 정점을 다 돈 경우
        return;
    }

    private static void bfs(List<Integer>[] graph, int nowVertex) {
        // 처음 시작 정점 처리
        if (!check[nowVertex]) {
            check[nowVertex] = true;
            System.out.print(nowVertex + " ");
        }

        // 연결된 정점에 순차 접근
        for (int e : graph[nowVertex]) {
            // 연결된 정점에 처리되지 않은 경우
            if (!check[e]) {
                // 연결된 정점 체크
                check[e] = true;
                // 출력
                System.out.print(e + " ");
                // 큐에 다음 정점 저장
                queue.add(e);
            }
        }

        // 큐가 비게될 때까지 다음 정점에 대해 bfs 처리
        while (!queue.isEmpty()) {
            bfs(graph, queue.pollFirst());
        }
    }

}
