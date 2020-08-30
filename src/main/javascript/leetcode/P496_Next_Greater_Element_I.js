var nextGreaterElement = function (nums1, nums2) {
    let result = [];

    for (let i = 0, len = nums1.length; i < len; i++) {
        let flag = false;

        for (let j = 0, len2 = nums2.length; j < len2; j++) {
            if (flag && nums1[i] < nums2[j]) {
                result[i] = nums2[j];
                break;
            }

            if (nums1[i] === nums2[j]) {
                flag = true;
            }
        }

        if (result[i] === undefined) {
            result[i] = -1;
        }
    }

    return result;
};

console.log(nextGreaterElement([4, 1, 2], [1, 3, 4, 2]));