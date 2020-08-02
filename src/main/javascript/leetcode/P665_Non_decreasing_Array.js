var checkPossibility = function(nums) {
    for (let i = 0, len = nums.length; i < len; i++) {
        if (isSorted(nums, i)) {
            return true;
        }
    }
    return false;
};

function isSorted(nums, excludedIndex) {
    for (let i = 0, len = nums.length; i < len; i++) {
        if (i == excludedIndex) {
            continue;
        }

        let nextIndex = i + 1 === excludedIndex ? i + 2 : i + 1;
        if (nextIndex === len) {
            break;
        }

        if (nums[i] > nums[nextIndex]) {
            return false;
        }
    }
    return true;
}

console.log(checkPossibility([4,2,1]));