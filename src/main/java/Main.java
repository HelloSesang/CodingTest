import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	private static int[] dp;

	private static Set<Integer> token = new HashSet<>();

	private static int min = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int tokenCount = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		dp = new int[total + 1];
		for (int i = 0; i < tokenCount; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp < min || min == 0) min = temp;
			token.add(temp);
		}
		System.out.println(getAnswer(total));
	}

	private static int getAnswer(int now) {
		if (dp[now] > 0) return dp[now];
		if (now < min) return 0;
		if (token.contains(now)) dp[now] += 1;
		token.forEach(integer -> dp[now] += getAnswer(now - integer));
		return dp[now];
	}

}
