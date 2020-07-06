var runningSum = function(nums) {
    var result = [];
    for (var i = 0; i < nums.length; i++) {
        var sum = 0;
        if (i > 0) {
            sum = result[i - 1];
        }
        sum += nums[i];
        result.push(sum);
    }
    return result
};

console.log(runningSum([1,2,3,4]));

