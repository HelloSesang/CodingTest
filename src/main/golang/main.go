package main

import "fmt"

func main() {
	nums := []int {2,4,0,1,0}
	fmt.Println(solve(nums))
}

func solve(nums []int) bool {
	return recursive(0, nums)
}

func recursive(index int, nums []int) bool {
	if index >= len(nums) - 1 {
		return true
	}

	if nums[index] <= 0 {
		return false
	}

	for i := nums[index]; i > 0; i-- {
		if recursive(index + i, nums) {
			return true
		} else {
			nums[index + i] = 0
		}
	}
	return false
}
