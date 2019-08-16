package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P11650_sort {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		List<Coordinate> list = new ArrayList<>();
		while (testCount-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Coordinate coordinate = new Coordinate(x, y);
			list.add(coordinate);
		}
		list.sort((o1, o2) -> {
			if (o1.getX() != o2.getX()) return o1.getX() - o2.getX();
			if (o1.getY() != o2.getY()) return o1.getY() - o2.getY();
			return 0;
		});
		list.stream().forEach(System.out::println);
	}

	static class Coordinate {

		private int x;

		private int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
