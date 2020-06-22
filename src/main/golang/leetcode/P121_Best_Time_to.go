package leetcode

func maxProfit(prices []int) int {
	min := math.MaxInt64
	max := 0
	for i := 0; i < len(prices); i++ {
		if min > prices[i] {
			min = prices[i]
		} else if prices[i] - min > max {
			max = prices[i] - min
		}
	}
	return max
}

func main() {
	fmt.Println(maxProfit([]int{7,1,5,3,6,4}))
}