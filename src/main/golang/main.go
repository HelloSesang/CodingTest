package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(solve(121))
}

func solve(num int) bool {
	numStr := strconv.Itoa(num)
	midIdx := len(numStr) / 2
	for start, end := 0, len(numStr) - 1; start < midIdx; start++ {
		if numStr[start] != numStr[end] {
			return false
		}
		end--
	}
	return true
}
