import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int[] graph;

	private static int[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int count = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			check = new int[count + 1];
			graph = new int[count + 1];
			for (int i = 1; i <= count; i++) {
				graph[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			for (int i = 1; i <= count; i++) {
				dfs(i);
			}
			bw.write(String.valueOf(answer));
			bw.newLine();
			bw.flush();
		}
	}

	private static boolean dfs(int now) {
		check[now] = 1;
		int next = graph[now];
		if (check[next] == 0) {
			dfs(next);
		} else {

		}
	}

}