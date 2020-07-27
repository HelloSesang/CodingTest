class Solution {
    solve(num) {
        let numStr = num.toString();
        let midIdx = numStr.length / 2;

        for (let start = 0, end = numStr.length - 1; start < midIdx; start++, end--) {
            if (numStr.charAt(start) !== numStr.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}

solution = new Solution();
console.log(solution.solve(121));