package leetcode

import (
	"math"
)

func reverse(x int) int {
	result := 0
	for ; x != 0; x /= 10 {
		result = (result * 10) + (x % 10)
	}

	if result > int(math.Pow(2, 31)-1) || result < int(-math.Pow(2, 31)) {
		result = 0
	}

	return result
}
