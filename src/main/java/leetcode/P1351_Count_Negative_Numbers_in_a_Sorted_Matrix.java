package leetcode;

public class P1351_Count_Negative_Numbers_in_a_Sorted_Matrix {

	public int countNegatives(int[][] grid) {
		int rowLength = grid.length;
		int colLength = grid[0].length;
		int firstNegativeIndex = colLength - 1;
		int result = 0;

		for (int row = 0; row < rowLength; row++) {
			if (grid[row][0] < 0) {
				result += colLength;
				continue;
			}

			if (grid[row][colLength - 1] > 0) {
				continue;
			}

			int left = 0;
			int right = firstNegativeIndex;

			while (left <= right) {
				int middle = left + (right - left) / 2;
				if (grid[row][middle] < 0) {
					right = middle - 1;
				} else
					left = middle + 1;
			}

			result += (colLength - left);
			firstNegativeIndex = left;
		}

		return result;
	}

}
