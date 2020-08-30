package teamstudy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2805_divideandconquer {

    private static int amount;

    private static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int treeCount = Integer.parseInt(st.nextToken());
        amount = Integer.parseInt(st.nextToken());
        trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        for (int height : trees) {
            if (max <= height) max = height;
        }
        System.out.println(getAnswer(0, max));
    }

    private static int getAnswer(int left, int right) {
        int middle = (left + right) / 2;
        if (left > right) return middle;
        long total = 0;
        for (int height : trees) {
            if (height > middle) total += height - middle;
        }
        if (total == amount) return middle;
        if (total > amount) {
            return getAnswer(middle + 1, right);
        } else {
            return getAnswer(left, middle - 1);
        }

    }

}
