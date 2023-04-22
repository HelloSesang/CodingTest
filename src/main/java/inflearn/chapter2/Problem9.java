package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();

        int[][] grid = new int[length][length];
        for (int i = 0; i < length; i++) {
            int[] line = Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            for (int j = 0; j < length; j++) {
                grid[i][j] = line[j];
            }
        }

        int max = 0;
        for (int rowIndex = 0; rowIndex < length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < length; columnIndex++) {
                int biggerRowOrColumnSum = getBiggerRowOrColumnSum(grid, rowIndex, columnIndex);
                max = max > biggerRowOrColumnSum ? max : biggerRowOrColumnSum;
            }
            int biggerDiagonalSum = getBiggerDiagonalSum(grid);
            max = max > biggerDiagonalSum ? max : biggerDiagonalSum;
        }
        System.out.println(max);
    }

    private static int getBiggerDiagonalSum(int[][] grid) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int left = 0, right = grid.length - 1, rowIndex = 0; left < grid.length; left++, right--, rowIndex++) {
            leftDiagonalSum += grid[rowIndex][left];
            rightDiagonalSum += grid[rowIndex][right];
        }
        return leftDiagonalSum >= rightDiagonalSum ? leftDiagonalSum : rightDiagonalSum;
    }

    private static int getBiggerRowOrColumnSum(int[][] grid, int rowIndex, int columnIndex) {
        int rowSum = 0;
        int columnSum = 0;
        for (int index = 0; index < grid.length; index++) {
            rowSum += grid[rowIndex][index];
            columnSum += grid[index][columnIndex];
        }
        return rowSum >= columnSum ? rowSum : columnSum;
    }
}
