package main

import "fmt"

func main() {
	nums := []int {8,1,2,2,3}
	fmt.Println(smallerNumbersThanCurrent(nums))
}

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