package main

import "fmt"

func main() {
	arr := []int {2,5,1,3,4,7}
	fmt.Println(shuffle(arr, 3))
}

func shuffle(nums []int, n int) []int {
	var result []int
	for i := 0; i < n; i++ {
		result = append(result, nums[i])
		result = append(result, nums[i + n])
	}
	return result
}