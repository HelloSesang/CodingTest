package algorithm.binarysearch;

public class Hoppable {

    /**
     * 첫 번째 해결 방법
     * 특징: 재귀, 2중 For문
     */
    public boolean solve1(int[] nums) {
        return recursive(0, nums);
    }

    /**
     * 개선된 해결 방법
     * 특징: Greedy 알고리즘
     * 상세: 첫 번째 해결 방법에서 2번째 For문을 최선의 경우만 확인하는 Greedy 알고리즘 적용으로 제거
     */
    public boolean solve(int[] nums) {
        int goal = nums.length - 1;
        int reachable = 0;

        for (int i = 0; i <= reachable; i++) {
            reachable = Math.max(reachable, i + nums[i]);

            if (reachable >= goal) {
                return true;
            }
        }
        return false;
    }

    private boolean recursive(int index, int[] nums) {
        if (nums.length - 1 <= index + nums[index]) {
            return true;
        }

        if (nums[index] == 0) {
            return false;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (recursive(index + i, nums)) {
                return true;
            } else {
                nums[index + i] = 0;
            }
        }

        return false;
    }

}
