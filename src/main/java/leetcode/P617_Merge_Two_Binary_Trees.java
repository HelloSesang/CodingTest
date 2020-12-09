package leetcode;

public class P617_Merge_Two_Binary_Trees {

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

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}

		TreeNode resultTree = new TreeNode();
		tourTree(t1, resultTree);
		tourTree(t2, resultTree);

		return resultTree;
	}

	private void tourTree(TreeNode node, TreeNode result) {
		if (node == null) return;

		result.val += node.val;

		if (node.left != null) {
			if (result.left == null) {
				result.left = new TreeNode();
			}
			tourTree(node.left, result.left);
		}

		if (node.right != null) {
			if (result.right == null) {
				result.right = new TreeNode();
			}
			tourTree(node.right, result.right);
		}
	}

}
