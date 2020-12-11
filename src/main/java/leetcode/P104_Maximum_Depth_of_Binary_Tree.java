package leetcode;

public class P104_Maximum_Depth_of_Binary_Tree {

    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return tourNode(root, 0);
    }

    private int tourNode(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftResult = tourNode(node.left, depth + 1);
        int rightResult = tourNode(node.right, depth + 1);

        return Math.max(leftResult, rightResult);
    }

}
