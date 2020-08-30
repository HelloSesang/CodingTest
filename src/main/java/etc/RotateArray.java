package etc;

public class RotateArray {

    private int[][] rotateArray(int[][] key) {
        int[][] newKey = new int[key.length][key[0].length];

        for (int i = 0, len = key.length; i < len; i++) {
            for (int j = 0, len2 = key[0].length; j < len; j++) {
                newKey[j][len - 1 - i] = key[i][j];
            }
        }
        return newKey;
    }

}
