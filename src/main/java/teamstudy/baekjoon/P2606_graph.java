package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2606_graph {

    private static BufferedReader br;

    private static List<Integer>[] connection;

    private static int[] checkYn;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int computerCnt = Integer.parseInt(br.readLine());
        int connectionCnt = Integer.parseInt(br.readLine());
        setData(computerCnt, connectionCnt);
        int answer = dfs(1) - 1;
        System.out.println(answer);
    }

    // 문제풀이를 위한 자료 구조 설정
    private static void setData(int computerCnt, int connectionCnt) throws Exception {
        checkYn = new int[computerCnt + 1];
        connection = new ArrayList[computerCnt + 1];
        for (int i = 1; i <= computerCnt; i++) {
            connection[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        int first = 0, second = 0;
        for (int i = 0; i < connectionCnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            connection[first].add(second);
            connection[second].add(first);
        }
    }

    private static int dfs(int now) {
        int answer = 1;
        checkYn[now] = 1;
        for (int e : connection[now]) {
            if (checkYn[e] == 0) {
                answer += dfs(e);
            }
        }
        return answer;
    }

}
