package kakao.blind2018.online;

import java.util.Arrays;

class Problem2 {

	public static void main(String[] args) {
		Problem2 solution = new Problem2();
		int[] arr = {1, 1, 1, 1};
		System.out.println(Arrays.toString(solution.solution(2, arr)));
	}

	public int[] solution(int N, int[] stages) {
		int[] playerNum1 = new int[N + 2];
		int[] playerNum2 = new int[N + 2];
		StageInfo[] stageInfos = new StageInfo[N];

		for (int i = 0, len = stages.length; i < len; i++) {
			playerNum1[stages[i]]++;
		}

		for (int i = 0, len = stages.length; i < len; i++) {
			for (int j = stages[i]; j > 0; j--) {
				playerNum2[j]++;
			}
		}

		for (int i = 0,len = stageInfos.length; i < len; i++) {
			stageInfos[i] = new StageInfo();
			stageInfos[i].stageNumber = i + 1;
			if (playerNum2[i + 1] == 0) {
				stageInfos[i].failure = 0;
			} else {
				stageInfos[i].failure = (double)playerNum1[i + 1] / playerNum2[i + 1];
			}

		}

		Arrays.sort(stageInfos, (o1, o2) -> {
			if (o1.failure == o2.failure) {
				return o1.stageNumber - o2.stageNumber;
			}
			if (o2.failure > o1.failure) {
				return 1;
			} else {
				return -1;
			}
		});

		int[] answer = new int[N];

		for (int i = 0, len = answer.length; i < len; i++) {
			answer[i] = stageInfos[i].stageNumber;
		}
		return answer;
	}

	class StageInfo {

		public int stageNumber;

		public double failure;

		@Override
		public String toString() {
			return "StageInfo{" +
					"stageNumber=" + stageNumber +
					", failure=" + failure +
					'}';
		}
	}
}