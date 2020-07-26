class Solution {
    solve(n) {
        let result = [];
        for (let i = 1; i <= n; i++) {
            if (this.checkCondition(i)) {
                result.push("clap");
            } else {
                result.push(i.toString());
            }
        }
        return result;
    }

    checkCondition(num) {
        if (num % 3 == 0) {
            return true;
        }

        let numStr = num.toString();
        for (let i = 0; i < numStr.length; i++) {
            let ch = numStr.charAt(i);
            if (ch === '3' || ch === '6' || ch === '9') {
                return true;
            }
        }
        return false;
    }
}

solution = new Solution();
solution.solve(16);
