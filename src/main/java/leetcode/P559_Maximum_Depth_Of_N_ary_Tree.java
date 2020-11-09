package leetcode;

import java.util.List;

public class P559_Maximum_Depth_Of_N_ary_Tree {

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}
		return tourTree(root, 1);
	}

	private int tourTree(Node currentNode, int currentDepth) {
		int maxDepth = 0;

		if (currentNode.children == null || currentNode.children.size() <= 0) {
			return currentDepth;
		} else {
			for (Node node : currentNode.children) {
				int maxDepthOfCurrentBranch = tourTree(node, currentDepth + 1);
				if (maxDepth < maxDepthOfCurrentBranch) {
					maxDepth = maxDepthOfCurrentBranch;
				}
			}
		}
		return maxDepth;
	}

}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}