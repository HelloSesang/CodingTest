package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1931_bruteforce_fail {

	private static int[][] meetingInfo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int meetingCnt = Integer.parseInt(br.readLine());
		meetingInfo = new int[meetingCnt][2];
		for (int i = 0; i < meetingCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meetingInfo[i][0] = Integer.parseInt(st.nextToken());
			meetingInfo[i][1] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i < meetingCnt; i++) {
			int max = getMax(1, 0);
			if (max > answer) answer = max;
		}
		System.out.println(answer);
	}

	private static int getMax(int cnt, int idx) {
		int endTime = meetingInfo[idx][1];
		int max = 0;
		for (int i = 0, len = meetingInfo.length; i < len; i++) {
			if (i == idx) continue;
			if (meetingInfo[i][0] >= endTime) {
				int temp = getMax(cnt + 1, i);
				if (temp > max) max = temp;
			}
		}
		return Math.max(cnt, max);
	}

}
