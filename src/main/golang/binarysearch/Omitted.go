package binarysearch

func omitted(nums []int) []int {
	isZeroExist := false
	zeroCount := 0
	max := 1

	for i, len := 0, len(nums); i < len; i++ {
		if nums[i] == 0 {
			isZeroExist = true
			zeroCount++
			continue
		}
		max *= nums[i]
	}

	result := make([]int, len(nums))
	for i, len := 0, len(result); i < len; i++ {
		if isZeroExist {
			if zeroCount > 1 {
				result[i] = 0
			} else {
				if nums[i] == 0 {
					result[i] = max
				} else {
					result[i] = 0
				}
			}
		} else {
			result[i] = max / nums[i]
		}
	}
	return result
}
