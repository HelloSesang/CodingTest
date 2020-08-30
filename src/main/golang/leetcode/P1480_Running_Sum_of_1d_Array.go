package leetcode

func runningSum(nums []int) []int {
	var result []int
	for i := 0; i < len(nums); i++ {
		var sum = 0
		if i > 0 {
			sum += result[i-1]
		}
		sum += nums[i]
		result = append(result, sum)
	}
	return result
}
