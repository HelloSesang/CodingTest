package main

import "fmt"

func main() {
	nums1 := []int {4,1,2}
	nums2 := []int {1,3,4,2}

	fmt.Println(nextGreaterElement(nums1, nums2))
}

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	result := make([]int, len(nums1))

	for i, len, len2 := 0, len(nums1), len(nums2); i < len; i++ {
		flag := false

		for j := 0; j < len2 ; j++ {
			if flag && nums1[i] < nums2[j] {
				result[i] = nums2[j]
				break
			}

			if nums1[i] == nums2[j] {
				flag = true
			}
		}

		if result[i] == 0 {
			result[i] = -1
		}
	}

	return result
}