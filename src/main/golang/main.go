package main

import (
	"fmt"
	"sort"
)

func solve(nums []int, k int) bool {
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

func main() {
	nums := []int {10, 36, 22, 14}
	var k int = 4
	fmt.Println(solve(nums, k))
}