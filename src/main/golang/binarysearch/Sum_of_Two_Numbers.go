package binarysearch

import (
	"sort"
)

func Sum_of_Two_Numbers(nums []int, k int) bool {
	sort.Ints(nums)

	minIdx := 0
	maxIdx := len(nums) - 1

	for minIdx < maxIdx {
		sum := nums[minIdx] + nums[maxIdx]
		if (sum == k) {
			return true
		} else if(sum < k) {
			minIdx++
		} else if(sum > k) {
			maxIdx--
		}
	}
	return false
}