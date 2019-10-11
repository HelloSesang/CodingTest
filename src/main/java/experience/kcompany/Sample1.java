package experience.kcompany;

import java.util.ArrayList;
import java.util.List;

public class Sample1 {

	static List<Integer> oddNumbers(int l, int r) {
		List<Integer> answer = new ArrayList<>();

		for (int i = l; i <= r; i++) {
			if (i % 2 == 1) {
				answer.add(i);
			}
		}
		return answer;
	}

}
