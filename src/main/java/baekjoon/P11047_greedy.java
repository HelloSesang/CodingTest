package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11047_greedy {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int coinCnt = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());
		List<Integer> coinList = new ArrayList<>();
		int answer = 0;
		while (coinCnt-- > 0) {
			coinList.add(Integer.parseInt(br.readLine()));
		}
		for (int i = coinList.size() - 1; i >= 0; i--) {
			int coin = coinList.get(i);
			if (coin <= value) {
				answer += value / coin;
				value %= coin;
			}
		}
		System.out.println(answer);
	}

}
