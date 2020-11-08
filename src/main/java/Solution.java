public class Solution {
	
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

		public void add(int val) {
			if (this.val == 0) {
				this.val = val;
				return;
			}

			if (this.val > val) {
				if (this.left == null) {
					this.left = new TreeNode(val);
				} else {
					this.left.add(val);
				}
			}

			if (this.val < val) {
				if (this.right == null) {
					this.right = new TreeNode(val);
				} else {
					this.right.add(val);
				}
			}
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = solution.makeTree();
		TreeNode rearrangedTree = solution.increasingBST(root);
	}

	private TreeNode makeTree() {
		TreeNode root = new TreeNode(5);
		root.add(3);
		root.add(6);
		root.add(2);
		root.add(4);
		root.add(8);
		root.add(1);
		root.add(7);
		root.add(9);

		return root;
	}

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

}
