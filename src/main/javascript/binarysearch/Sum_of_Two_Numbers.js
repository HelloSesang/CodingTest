class Solution {
    solve(nums, k) {
        nums.sort((a, b) => {
            return a - b;
        })

        let minIdx = 0;
        let maxIdx = nums.length - 1;

        while (minIdx < maxIdx) {
            let sum = nums[minIdx] + nums[maxIdx];

            if (sum == k) {
                return true;
            } else if (sum < k) {
                minIdx++;
            } else if (sum > k) {
                maxIdx--;
            }
        }
        return false
    }
}

solution = new Solution();
nums = [10, 36, 22, 14];
k = 4;

console.log(solution.solve(nums, k));