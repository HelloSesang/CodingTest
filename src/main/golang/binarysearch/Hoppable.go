package binarysearch

func Hoppable(nums []int) bool {
	return recursive(0, nums)
}

func recursive(index int, nums []int) bool {
	if index >= len(nums)-1 {
		return true
	}

	if nums[index] <= 0 {
		return false
	}

	for i := nums[index]; i > 0; i-- {
		if recursive(index+i, nums) {
			return true
		} else {
			nums[index+i] = 0
		}
	}
	return false
}
