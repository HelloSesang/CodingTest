package etc;

import java.util.Arrays;

public class SpiralArray {

    public static void main(String[] args) throws Exception {
        int[][] arr = new int[6][5];
        int xLen = arr[0].length;
        int yLen = arr.length;
        int arrLen = arr.length * arr[0].length;
        int x = 0, y = 0, direction = 0;

        for (int i = 1; i <= arrLen; i++) {
            arr[y][x] = i;
            switch (direction % 4) {
                case 0:
                    if (x < xLen - 1 && arr[y][x + 1] == 0) {
                        x++;
                    } else {
                        direction++;
                        y++;
                    }
                    break;
                case 1:
                    if (y < yLen - 1 && arr[y + 1][x] == 0) {
                        y++;
                    } else {
                        direction++;
                        x--;
                    }
                    break;
                case 2:
                    if (x > 0 && arr[y][x - 1] == 0) {
                        x--;
                    } else {
                        direction++;
                        y--;
                    }
                    break;
                case 3:
                    if (y > 0 && arr[y - 1][x] == 0) {
                        y--;
                    } else {
                        direction++;
                        x++;
                    }
                    break;
            }
        }

        for (int i = 0, len = arr.length; i < len; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}

