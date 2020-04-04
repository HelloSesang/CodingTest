package leetcode

func isPalindrome(x int) bool {
	temp := []int{}
	for ; x != 0; x /= 10 {
		temp = append([]int{x % 10}, temp...)
	}

	result := true
	for i, j := 0, len(temp) - 1; i <= j; i++ {
		if temp[i] != temp[j] || temp[i] < 0 {
			result = false
			break
		}
		j--
	}

	return result
}