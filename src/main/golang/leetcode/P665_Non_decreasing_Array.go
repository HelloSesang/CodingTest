package leetcode

func checkPossibility(nums []int) bool {
	for i, len := 0, len(nums); i < len; i++ {
		if isSorted(nums, i) {
			return true
		}
	}
	return false
}

func isSorted(nums []int, excludedIndex int) bool {
	for i, len := 0, len(nums); i < len; i++ {
		if i == excludedIndex {
			continue
		}

		nextIndex := i + 1
		if nextIndex == excludedIndex {
			nextIndex = i + 2
		}

		if nextIndex >= len {
			break
		}

		if nums[i] > nums[nextIndex] {
			return false
		}
	}
	return true
}
