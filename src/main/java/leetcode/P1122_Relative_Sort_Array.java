package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class P1122_Relative_Sort_Array {

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		List<Integer> answer = new ArrayList<>();

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int number : arr1) {
			int count = map.getOrDefault(number, 0);
			map.put(number, count + 1);
		}

		for (int number : arr2) {
			int count = map.getOrDefault(number, 0);
			for (int i = 0; i < count; i++) {
				answer.add(number);
			}
			map.put(number, 0);
		}

		for (Integer key : map.keySet()) {
			int count = map.getOrDefault(key, 0);
			for (int i = 0; i < count; i++) {
				answer.add(key);
			}
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

}
