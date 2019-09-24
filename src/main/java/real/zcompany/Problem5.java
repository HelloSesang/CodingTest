package real.zcompany;

public class Problem5 {

	public static void main(String[] args) {
		Problem5 problem5 = new Problem5();
		int[] arr = {1, 2, 3, 0, 3};
		System.out.println(problem5.solution(arr));
	}

	public int solution(int[] foods) {
		int answer = 0;

		for (int x = 1, len = foods.length; x < len - 1; x++) {
			for (int y = x + 1; y < len; y++) {
				int satiety1 = 0, satiety2 = 0, satiety3 = 0;
				for (int i = 0; i < x; i++) {
					satiety1 += foods[i];
				}
				for (int i = x; i < y; i++) {
					satiety2 += foods[i];
				}
				for (int i = y; i < len; i++) {
					satiety3 += foods[i];
				}
				if (satiety1 == satiety2 && satiety2 == satiety3) {
					answer++;
				}
			}
		}
		return answer;
	}

}