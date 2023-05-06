package inflearn.chapter2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Problem10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();

        int[][] grid = new int[length][length];
        IntStream.range(0, length).forEach(index -> {
            String[] input = in.nextLine().split(" ");
            int[] convertedInput = Arrays.stream(input)
                    .mapToInt(value -> Integer.parseInt(value))
                    .toArray();
            grid[index] = convertedInput;
        });

        AtomicInteger result = new AtomicInteger(0);
        IntStream.range(0, length).forEach(x -> {
            IntStream.range(0, length).forEach(y -> {
                if (isPeak(grid, x, y)) {
                    result.incrementAndGet();
                }
            });
        });

        System.out.println(result.get());
    }

    private static boolean isPeak(int[][] grid, int x, int y) {
        int currentHeight = grid[x][y];
        int leftHeight = isLeftExist(x) ? 0 : grid[x-1][y];
        int rightHeight = isRightExist(grid, x) ? 0 : grid[x+1][y];
        int topHeight = isTopExist(y) ? 0 : grid[x][y-1];
        int bottomHeight = isBottomExist(grid, y) ? 0 : grid[x][y+1];

        return currentHeight > leftHeight &&
                currentHeight > rightHeight &&
                currentHeight > topHeight &&
                currentHeight > bottomHeight;
    }

    private static boolean isLeftExist(int x) {
        return x - 1 < 0;
    }

    private static boolean isRightExist(int[][] grid, int x) {
        return x + 1 >= grid.length;
    }

    private static boolean isTopExist(int y) {
        return y - 1 < 0;
    }

    private static boolean isBottomExist(int[][] grid, int y) {
        return y + 1 >= grid.length;
    }
}
