package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class P973_K_Closest_Points_to_Origin {

	public int[][] kClosest(int[][] points, int K) {
		int [][] answer = new int[K][2];
		TreeMap<Double, ArrayList<int[]>> map = new TreeMap<>();

		for (int[] point : points) {
			double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
			ArrayList<int[]> list = map.getOrDefault(distance, new ArrayList<>());
			list.add(point);
			map.put(distance, list);
		}

		Iterator<Double> iterator = map.keySet().iterator();
		int i = 0;
		while (i < K) {
			ArrayList<int[]> list = map.get(iterator.next());
			for (int[] point : list) {
				answer[i] = point;
				i++;
				if (i >= K) {
					break;
				}
			}
		}

		return answer;
	}

}
