package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	아예 감을 잡지 못하고 문제풀이를 확인
	유니온 파인드를 이용해서 문제를 풀어야한다는 것을 찾게됨
	유니온 파인드는 유니온과 파인드 두 가지 연산으로 이루어짐
	유니온은 두 집합을 합치는 연산
	파인드는 대상 값이 속한 집합의 루트를 찾는 연산
	유니온을 할 때 파인드를 이용해서 루트를 찾고 두 집합의 루트를 대상으로 유니온을 해야한다.
	그래야지 집합이 제대로 합쳐진다.
	파인드 연산 시 자신의 루트를 가장 최상위 루트의 값으로 바꿔주면 트리의 깊이를 낮춰서 성능을 올릴 수 있다.
 */

public class P1717_unionfind {

    private static int[] rootInfo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int setCount = Integer.parseInt(st.nextToken());
        int commandCount = Integer.parseInt(st.nextToken());
        rootInfo = new int[setCount + 1];

        // O(n)
        for (int i = 0; i <= setCount; i++) {
            rootInfo[i] = i;
        }

        while (commandCount-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if (command.equals("0")) {
                union(first, second);
            } else {
                if (find(first) == find(second)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // O(n)
    private static int find(int target) {
        if (rootInfo[target] == target) {
            return target;
        }
        rootInfo[target] = find(rootInfo[target]);
        return rootInfo[target];
    }

    // O(1)
    private static void union(int first, int second) {
        if (first == second) return;
        first = find(first);
        second = find(second);
        rootInfo[second] = first;
    }

}
