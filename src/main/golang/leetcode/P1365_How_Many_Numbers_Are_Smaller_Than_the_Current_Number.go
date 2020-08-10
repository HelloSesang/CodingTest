package leetcode

func smallerNumbersThanCurrent(nums []int) []int {
	result := make([]int, len(nums))

	for i, len := 0, len(nums); i < len; i++ {
		for j := 0; j < len; j++ {
			if i == j {
				continue
			}

			if nums[i] > nums[j] {
				result[i]++
			}
		}
	}

	return result
}