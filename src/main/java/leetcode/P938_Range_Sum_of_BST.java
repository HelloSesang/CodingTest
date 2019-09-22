package leetcode;

public class P938_Range_Sum_of_BST {

	public static void main(String[] args) {
		P938_Range_Sum_of_BST obj = new P938_Range_Sum_of_BST();
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		return recursive(root, L, R);
	}

	private int recursive(TreeNode root, int L, int R) {
		if (root == null) {
			return 0;
		}

		int answer = 0;
		if (root.val >= L && root.val <= R) {
			answer += root.val;
		}

		return answer + recursive(root.left, L, R) + recursive(root.right, L, R);
	}

}

class TreeNode {
 	int val;
 	TreeNode left;
 	TreeNode right;
	TreeNode(int x) { val = x; }
 }