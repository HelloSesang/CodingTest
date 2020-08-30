package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P9466_graph {

    private static int[] graph;

    private static int[] visitOrderArr;

    private static int[] repeatOrderArr;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int testCnt = Integer.parseInt(br.readLine());

        while (testCnt-- > 0) {
            int studentCnt = Integer.parseInt(br.readLine());
            setGraph(studentCnt);
            int answer = 0;
            for (int i = 1; i <= studentCnt; i++) {
                if (visitOrderArr[i] == 0)
                    answer += (dfs(i, 1, i) - 1);
            }
            printAnswer(answer);
        }
    }

    private static int dfs(int now, int visitOrder, int repeatOrder) {
        visitOrderArr[now] = visitOrder;
        repeatOrderArr[now] = repeatOrder;
        int next = graph[now];

        if (visitOrderArr[next] == 0) {
            return dfs(next, visitOrder + 1, repeatOrder);
        } else {
            if (repeatOrderArr[next] == repeatOrder) {
                return visitOrderArr[next];
            } else {
                return visitOrder + 1;
            }
        }
    }

    private static void setGraph(int studentCnt) throws Exception {
        visitOrderArr = new int[studentCnt + 1];
        repeatOrderArr = new int[studentCnt + 1];
        graph = new int[studentCnt + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= studentCnt; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void printAnswer(int answer) throws Exception {
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }

}