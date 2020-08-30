package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1991_tree {

    private static int[][] tree;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int nodeCnt = Integer.parseInt(br.readLine());
        setTree(nodeCnt);
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    private static void setTree(int nodeCnt) throws Exception {
        tree = new int[nodeCnt][2];
        for (int i = 0; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = st.nextToken().charAt(0) - 65;
            int left = st.nextToken().charAt(0) - 65;
            int right = st.nextToken().charAt(0) - 65;
            tree[parent][0] = left >= 0 && left <= 25 ? left : -1;
            tree[parent][1] = right >= 0 && right <= 25 ? right : -1;
        }
    }

    private static void preOrder(int parent) {
        if (parent < 0) return;
        System.out.print((char) (parent + 65));
        preOrder(tree[parent][0]);
        preOrder(tree[parent][1]);
    }

    private static void inOrder(int parent) {
        if (parent < 0) return;
        inOrder(tree[parent][0]);
        System.out.print((char) (parent + 65));
        inOrder(tree[parent][1]);
    }

    private static void postOrder(int parent) {
        if (parent < 0) return;
        postOrder(tree[parent][0]);
        postOrder(tree[parent][1]);
        System.out.print((char) (parent + 65));
    }

}
