package bstcp;

import java.util.Map;
import java.util.TreeMap;

public class BCSecondProblem {

	public static void main(String[] args) {
//		int[] arr1 = {1, 5, 7, 2, 9, 13, 10};
//		int[] arr2 = {2, 3, 9, 10, 4, 8, 11};
//		int[] arr1 = {1, 4, 1, 3, 5, 6, 10};
//		int[] arr2 = {9, 2, 3, 1, 3, 4, 10};
//		int[] arr1 = {1, 1, 9, 4, 1, 3, 11};
//		int[] arr2 = {2, 3, 3, 13, 12, 9, 9};
//		int[] arr1 = {1, 4, 9, 4, 1, 10, 13};
//		int[] arr2 = {11, 13, 9, 3, 1, 9, 1};
//		int[] arr1 = {1, 4, 4, 4, 1, 10, 4};
//		int[] arr2 = {11, 13, 11, 3, 11, 9, 1};
		int[] arr1 = {1, 2, 2, 3, 2, 2, 2};
		int[] arr2 = {4, 5, 4, 5, 4, 5, 4};

		System.out.println(solution(arr1, arr2));
	}

	public static int solution(int[] arr1, int[] arr2) {
		Pair pair1 = getPair(arr1);
		Pair pair2 = getPair(arr2);

		if (pair1.equals(pair2)) {
			return 0;
		} else {
			if (pair1.getCount() != pair2.getCount() && (pair1.getCount() < 4 || pair2.getCount() < 4)) {
				if (pair1.getCount() > pair2.getCount()) {
					return 1;
				} else {
					return 2;
				}
			} else {
				if (pair1.getNumber() > pair2.getNumber()) {
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	public static Pair getPair(int[] arr) {
		Map<Integer, Integer> map = new TreeMap<>();
		Pair pair = new Pair();

		for (int e : arr) {
			int cnt = map.getOrDefault(e, 0);
			map.put(e, cnt + 1);
		}

		for (Integer e : map.keySet()) {
			int count = map.get(e);
			if (count > 1 && count >= pair.getCount()) {
				pair.setNumber(e);
				pair.setCount(count);
			}
		}

		return pair;
	}

}

class Pair {

	private int number;

	private int count;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public boolean equals(Object obj) {
		Pair target = (Pair) obj;

		if (this.number == target.getNumber() && this.count == target.getCount()) {
			return true;
		} else {
			return false;
		}
	}

}
