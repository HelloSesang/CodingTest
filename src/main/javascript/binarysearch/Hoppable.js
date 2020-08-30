class Solution {
    solve(nums) {
        return this.recursive(0, nums)
    }

    recursive(index, nums) {
        if (index >= nums.length - 1) {
            return true;
        }

        if (nums[index] <= 0) {
            return false;
        }

        for (let i = nums[index]; i > 0; i--) {
            if (this.recursive(index + i, nums)) {
                return true;
            } else {
                nums[index + i] = 0;
            }
        }
        return false;
    }
}

let solution = new Solution();
solution.solve([2, 4, 0, 1, 0]);