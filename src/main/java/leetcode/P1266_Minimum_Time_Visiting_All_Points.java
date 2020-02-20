package leetcode;

public class P1266_Minimum_Time_Visiting_All_Points {

	public static void main(String[] args) {
		P1266_Minimum_Time_Visiting_All_Points obj = new P1266_Minimum_Time_Visiting_All_Points();
		int[][] param = {{1,1},{3,4},{-1,0}};
		obj.minTimeToVisitAllPoints(param);
	}

	public int minTimeToVisitAllPoints(int[][] points) {

		int count = 0;

		for (int i = 1; i < points.length; i++) {
			int xPos = Math.abs(points[i-1][0] - points[i][0]);
			int yPos = Math.abs(points[i-1][1] - points[i][1]);

			count += Math.max(xPos, yPos);
		}

		return count;
	}
}
