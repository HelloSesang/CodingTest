package kakao.blind2019.online;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	public static void main(String[] args) {
		Problem3 solution = new Problem3();
		int[][] arr1 = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] arr2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(solution.solution(arr1, arr2));
	}

	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int[] lockArr = new int[lock.length * lock.length];
		for (int i = 0, len = lock.length; i < len; i++) {
			for (int j = 0; j < len; j++) {
				lockArr[(i * len) + j] = lock[i][j];
			}
		}

		for (int n = 0; n < 3; n++) {
			int[] keyArr = new int[key.length * key.length];
			for (int i = 0, len = key.length; i < len; i++) {
				for (int j =0; j < len; j++) {
					keyArr[(i * len) + j] = key[i][j];
				}
			}

			if (checkMatching(keyArr, lockArr)) {
				answer = true;
				break;
			}
			key = rotate(key);
		}
		return answer;
	}

	private boolean checkMatching(int[] keyArr, int[] lockArr) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		for (int i = 0; i < lockArr.length; i++) {
			if (lockArr[i] == 0) {
				list.add(i);
			}
		}

		for (int i = 0; i < keyArr.length; i++) {
			if (keyArr[i] == 1) {
				list2.add(i);
			}
		}

		for (int i = 1; i < list.size(); i++) {
			list3.add(list.get(i) - list.get(i - 1));
		}

		for (int i = 1; i < list2.size(); i++) {
			list4.add(list2.get(i) - list2.get(i - 1));
		}

		boolean result = true;
		for (int i = 0; i < list3.size(); i++) {
			if (!list4.contains(list3.get(i))) {
				result = false;
				break;
			}
		}
		return result;
	}

	private int[][] rotate(int[][] a) {
		int n = a.length;
		for(int i = 0; i < n / 2; i++){
			for(int j = i; j < n-i-1; j++){
				int temp = a[i][j];
				a[i][j] = a[n-j-1][i];
				a[n-j-1][i] = a[n-1-i][n-1-j];
				a[n-1-i][n-1-j] = a[j][n-1-i];
				a[j][n-1-i] = temp;
			}
		}
		return a;
	}
}