package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717_unionfind {

	private static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int setCount = Integer.parseInt(st.nextToken());
		int commandCount = Integer.parseInt(st.nextToken());
		parent = new int[setCount + 1];

		for (int i = 0; i <= setCount; i++) {
			parent[i] = i;
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

	private static int find(int target) {
		if (parent[target] == target) {
			return target;
		}
		parent[target] = find(parent[target]);
		return parent[target];
	}

	private static void union(int first, int second) {
		if (first == second) return;
		first = find(first);
		second = find(second);
		parent[second] = first;
	}

}
