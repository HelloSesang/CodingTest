package experience.zcompany;

import java.util.*;

public class Problem2 {

	public static void main(String[] args) {
		Problem2 problem2 = new Problem2();
		String[] arr = {"U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U"};
		problem2.solution(arr);
	}

	public int solution(String[] moves) {
		List<String> list = new ArrayList<>(Arrays.asList(moves));
		int answer = 0;
		boolean flag = true;
		while(flag) {
			flag = false;
			for (int i = 0, len = list.size(); i < len; i++) {
				list.get(i);
			}
		}



		return answer;
	}

}

