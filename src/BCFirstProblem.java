import java.util.*;

public class BCFirstProblem {

	public static void main(String[] args) {
//		int[] arr = {1,2,3,3,3,4,4};
//		int[] arr = {3,2,4,4,2,5,2,5,5};
		int[] arr = {3,5,7,9,1};
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int[] arr) {
		Map<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();

		for (int e : arr) {
			int cnt = map.getOrDefault(e, 0);
			map.put(e, cnt + 1);
		}

		for (Integer e : map.keySet()) {
			int value = map.get(e);
			if (value > 1)
				list.add(value);
		}

		if (list.size() == 0) return new int[]{-1};

		int[] result = new int[list.size()];

		for (int i = 0, len = result.length; i < len; i++)
			result[i] = list.get(i);

		return result;
	}

}