package leetcode;

public class P897_Increasing_Order_Search_Tree {

	public TreeNode increasingBST(TreeNode root) {
		TreeNode arrangedTree = new TreeNode(-1);
		inorder(root, arrangedTree);
		return arrangedTree;
	}

	private void inorder(TreeNode currentNode, TreeNode arrangedTree) {
		if (currentNode.left != null) {
			inorder(currentNode.left, arrangedTree);
		}

		add(arrangedTree, currentNode.val);

		if (currentNode.right != null) {
			inorder(currentNode.right, arrangedTree);
		}
	}

	private void add(TreeNode currentNode, Integer val) {
		if (currentNode.val < 0) {
			currentNode.val = val;
			return;
		}

		if (currentNode.val > val) {
			if (currentNode.left == null) {
				currentNode.left = new TreeNode(val);
			} else {
				add(currentNode.left, val);
			}
		}

		if (currentNode.val < val) {
			if (currentNode.right == null) {
				currentNode.right = new TreeNode(val);
			} else {
				add(currentNode.right, val);
			}
		}
	}

	public class TreeNode {
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

}
