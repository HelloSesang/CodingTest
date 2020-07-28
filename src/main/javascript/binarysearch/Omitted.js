class Solution {
    solve(nums) {
        let isZeroExist = false;
        let zeroCount = 0;
        let max = 1;

        for (let i = 0, len = nums.length; i < len; i++) {
            if (nums[i] === 0) {
                isZeroExist = true;
                zeroCount++;
                continue;
            }
            max *= nums[i];
        }

        let result = [];
        for (let i = 0, len = nums.length; i < len; i++) {
            if (isZeroExist) {
                if (zeroCount > 1) {
                    result.push(0);
                } else {
                    if (nums[i] === 0) {
                        result.push(max);
                    } else {
                        result.push(0);
                    }
                }
            } else {
                result.push(Math.floor(max / nums[i]));
            }
        }
        return result;
    }
}

solution = new Solution();
console.log(solution.solve([0,0]));
