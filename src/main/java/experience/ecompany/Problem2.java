package experience.ecompany;

/*
	노드 안에는 숫자가 존재한다.
	left는 좌측 자식 노드
	right는 우측 자식 노드
	중복되는 숫자가 없는 트리의 깊이 중 가장 긴 것을 반환하라.
*/

import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public static void main(String[] args) {
        Problem2 obj = new Problem2();
        Tree tree = new Tree();
        tree.x = 1;
        tree.right = new Tree();
        tree.right.x = 2;
        tree.right.left = new Tree();
        tree.right.left.x = 1;
        tree.right.right = new Tree();
        tree.right.right.x = 1;
        tree.right.right.left = new Tree();
        tree.right.right.left.x = 4;

        int result = obj.solution(tree);
        System.out.println(result);
    }

    public int solution(Tree T) {
        Set<Integer> set = new HashSet<>();
        return recursive(T, set, 0, 0);
    }

    private int recursive(Tree T, Set<Integer> set, int depth, int maxDepth) {
        // 끝에 도달했거나 중복이 발생한 경우
        if (T == null || set.contains(T.x)) {
            if (maxDepth < depth) {
                maxDepth = depth;
            }
            return maxDepth;
        }

        // set에 담는다.
        set.add(T.x);
        // depth를 1 카운팅한다.
        depth += 1;
        // 왼쪽 노드로 dfs
        int leftResult = recursive(T.left, set, depth, maxDepth);
        if (leftResult > maxDepth) {
            maxDepth = leftResult;
        }
        // 오른쪽 노드로 dfs
        int rightResult = recursive(T.right, set, depth, maxDepth);
        if (rightResult > maxDepth) {
            maxDepth = rightResult;
        }
        // 처리가 끝난 것은 set에서 제거한다.
        set.remove(T.x);

        return maxDepth;
    }

    static class Tree {
        public int x;
        public Tree left;
        public Tree right;
    }

}


/*
Tree tree = new Tree();
		tree.x = 1;
		tree.left = new Tree();
		tree.left.x = 2;
		tree.left.left = new Tree();
		tree.left.left.x = 1;
		tree.left.right = new Tree();
		tree.left.right.x = 2;

		tree.right = new Tree();
		tree.right.x = 2;
		tree.right.left = new Tree();
		tree.right.left.x = 4;
		tree.right.right = new Tree();
		tree.right.right.x = 1;
 */

/*
Tree tree = new Tree();
tree.x = 1;
	tree.left = new Tree();
		tree.left.x = 2;
		tree.left.left = new Tree();
		tree.left.left.x = 3;
		tree.left.right = new Tree();
		tree.left.right.x = 6;
		tree.left.left.left = new Tree();
		tree.left.left.left.x = 2;

		tree.right = new Tree();
		tree.right.x = 3;
		tree.right.left = new Tree();
		tree.right.left.x = 3;
		tree.right.right = new Tree();
		tree.right.right.x = 1;
		tree.right.right.left = new Tree();
		tree.right.right.left.x = 5;
		tree.right.right.right = new Tree();
		tree.right.right.right.x = 6;
*/

/*
	Tree tree = new Tree();
		tree.x = 1;
		tree.right = new Tree();
		tree.right.x = 2;
		tree.right.left = new Tree();
		tree.right.left.x = 1;
		tree.right.right = new Tree();
		tree.right.right.x = 1;
		tree.right.right.left = new Tree();
		tree.right.right.left.x = 4;
 */