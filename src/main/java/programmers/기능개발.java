package programmers;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
		int[] nessaryPeriod = new int[progresses.length];

		for (int i = 0, len = progresses.length; i < len; i++) {
			int restPercent = 100 - progresses[i];
			nessaryPeriod[i] = restPercent / speeds[i];

			if (restPercent % speeds[i] != 0) {
				nessaryPeriod[i]++;
			}
		}

		List<Integer> list = new ArrayList<>();
		int count = 1;
		int minPeriod = nessaryPeriod[0];
		for (int i = 1, len = nessaryPeriod.length; i < len; i++) {
			if (nessaryPeriod[i] <= minPeriod) {
				count++;
			} else {
				list.add(count);
				minPeriod = nessaryPeriod[i];
				count = 1;
			}

			if (i + 1 >= len) {
				list.add(count);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0, len = answer.length; i < len; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
