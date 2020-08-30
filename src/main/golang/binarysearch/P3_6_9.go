package binarysearch

import "strconv"

func P3_6_9(n int) []string {
	var result = make([]string, n)

	for i := 1; i <= n; i++ {
		if checkCondition(i) {
			result[i-1] = "clap"
		} else {
			result[i-1] = strconv.Itoa(i)
		}
	}
	return result
}

func checkCondition(num int) bool {
	if num%3 == 0 {
		return true
	}

	numStr := strconv.Itoa(num)
	for i := 0; i < len(numStr); i++ {
		if numStr[i:i+1] == "3" || numStr[i:i+1] == "6" || numStr[i:i+1] == "9" {
			return true
		}
	}
	return false
}
