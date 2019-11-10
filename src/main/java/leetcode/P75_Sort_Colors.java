package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P75_Sort_Colors {

	public void sortColors(int[] nums) {
		// 배열을 리스트에 옮겨담는다.
		List<Integer> numbers = new ArrayList<>();
		for (int number : nums) {
			numbers.add(number);
		}

		// sort 메서드로 전달해 리스트를 정렬한다.
		numbers = quickSort(numbers);

		// 정렬된 리스트를 배열로 다시 옮겨담는다.
		for (int i = 0, len = numbers.size(); i < len; i++) {
			nums[i] = numbers.get(i);
		}
	}

	private List<Integer> quickSort(List<Integer> numbers) {
		// nums의 길이가 1보다 작거나 같은 경우
		if (numbers.size() <= 1) {
			// return nums;
			return numbers;
		}

		// Pivot보다 작은 수와 큰 수를 나눠담을 리스트 자료구조를 생성한다.
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> same = new ArrayList<>();

		// Pivot 설정을 위한 랜덤 인덱스 값을 생성한다.
		Random random = new Random();
		int randomIndex = random.nextInt(numbers.size());

		// Pivot을 하나 잡는다.
		int pivot = numbers.get(randomIndex);

		// 리스트에 순차접근한다.
		for (int number : numbers) {
			// Pivot을 기준으로 작은 것들은 left에 담는다.
			if (number < pivot) {
				left.add(number);
				continue;
			}
			// Pivot을 기준으로 같은 것들은 same에 담는다.
			if (number == pivot) {
				same.add(number);
				continue;
			}
			// Pivot을 기준으로 큰 것들은 right에 담는다.
			if (number > pivot) {
				right.add(number);
				continue;
			}
		}

		// left와 rigth를 정렬한 후 합친 결과를 반환한다.
		final List<Integer> sorted = quickSort(left);
		sorted.addAll(same);
		sorted.addAll(quickSort(right));
		return sorted;
	}

}
