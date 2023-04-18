package kblind.blind2019.online;

public class Problem3 {

    public static void main(String[] args) {
        Problem3 solution = new Problem3();
        int[][] arr1 = {{0, 0, 0}, {1, 0, 0}, {1, 0, 1}};
        int[][] arr2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean answer = solution.solution(arr1, arr2);
        System.out.println(answer);
    }

    public boolean solution(int[][] key, int[][] lock) {
        // 키를 시계방향으로 회전시키는 반복문
        for (int i = 0; i < 4; i++) {

            // 키를 temp 배열에 새로 옮겨담고 temp 배열을 오른쪽으로 이동시키면서 자물쇠가 맞는지 확인
            int[][] temp = deepCopy(key);
            for (int j = 0, len = key.length * key[0].length; j < len; j++) {

                // 키와 자물쇠의 각 요소를 비교하면서 서로 맞지 않는 경우 flag를 false로 변경
                boolean flag = true;
                for (int k = 0, row = key.length; k < row; k++) {
                    for (int l = 0, col = key[0].length; l < col; l++) {
                        if (temp[k][l] == 0 && lock[k][l] == 0) {
                            flag = false;
                        }
                        if (temp[k][l] == 1 && lock[k][l] == 1) {
                            flag = false;
                        }
                    }
                }

                // 자물쇠가 맞다고 판명된 경우 true를 반환
                if (flag) {
                    return true;
                }

                // 자물쇠가 맞지 않는 경우 키를 이동시킨 후 다시 확인
                temp = moveRight(temp);
            }

            // 키를 temp 배열에 새로 옮겨담고 temp 배열을 왼쪽으로 이동시키면서 자물쇠가 맞는지 확인
            temp = deepCopy(key);
            for (int j = 0, len = key.length * key[0].length; j < len; j++) {

                // 키와 자물쇠의 각 요소를 비교하면서 서로 맞지 않는 경우 flag를 false로 변경
                boolean flag = true;
                for (int k = 0, row = key.length; k < row; k++) {
                    for (int l = 0, col = key[0].length; l < col; l++) {
                        if (temp[k][l] == lock[k][l]) {
                            flag = false;
                        }
                        if (temp[k][l] == 1 && lock[k][l] == 1) {
                            flag = false;
                        }
                    }
                }

                // 자물쇠가 맞다고 판명된 경우 true를 반환
                if (flag) {
                    return true;
                }

                // 자물쇠가 맞지 않는 경우 키를 이동시킨 후 다시 확인
                temp = moveLeft(temp);
            }

            key = rotateArray(key);
        }

        // 자물쇠가 맞는 경우가 존재하지 않으므로 false 반환
        return false;
    }

    // 2차원 배열의 각 요소를 한칸씩 왼쪽으로 이동시키는 메소드
    private int[][] moveLeft(int[][] key) {
        for (int i = 0, row = key.length; i < row; i++) {
            for (int j = 0, col = key.length; j < col; j++) {
                if (i == row - 1 && j == col - 1) {
                    key[i][j] = 0;
                    break;
                }

                if (j + 1 < col) {
                    key[i][j] = key[i][j + 1];
                } else {
                    key[i][j] = key[i + 1][0];
                }
            }
        }
        return key;
    }

    // 2차원 배열의 각 요소를 한칸씩 오른쪽으로 이동시키는 메소드
    private int[][] moveRight(int[][] key) {
        for (int i = key.length - 1; i >= 0; i--) {
            for (int j = key[0].length - 1; j >= 0; j--) {
                if (i == 0 && j == 0) {
                    key[i][j] = 0;
                    break;
                }

                if (j - 1 >= 0) {
                    key[i][j] = key[i][j - 1];
                } else {
                    key[i][j] = key[i - 1][key[0].length - 1];
                }
            }
        }
        return key;
    }

    // 2차원 배열을 시계 방향으로 회전시키는 메소드
    private int[][] rotateArray(int[][] key) {
        int[][] newKey = new int[key.length][key[0].length];

        for (int i = 0, len = key.length; i < len; i++) {
            for (int j = 0, len2 = key[0].length; j < len2; j++) {
                newKey[j][len - i - 1] = key[i][j];
            }
        }
        return newKey;
    }

    // 이차원 배열을 깊은 복사하기 위한 메소드
    private static int[][] deepCopy(int[][] original2) {
        if (original2 == null) return null;
        int[][] result = new int[original2.length][original2[0].length];

        for (int i = 0; i < original2.length; i++) {
            System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
        }

        return result;
    }
}