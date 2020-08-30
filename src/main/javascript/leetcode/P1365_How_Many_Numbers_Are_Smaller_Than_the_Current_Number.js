let smallerNumbersThanCurrent = function (nums) {
    let result = new Array(nums.length).fill(0);

    for (let i = 0, len = nums.length; i < len; i++) {
        for (let j = 0; j < len; j++) {
            if (i === j) continue;

            if (nums[i] > nums[j]) {
                result[i]++;
            }
        }
    }
    return result;
};

console.log(smallerNumbersThanCurrent([8, 1, 2, 2, 3]));