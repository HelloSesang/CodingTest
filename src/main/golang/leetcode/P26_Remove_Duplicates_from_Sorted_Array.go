package leetcode

import (
	"fmt"
	"sort"
)

type Asc []int

func (a Asc) Len() int {
	return len(a)
}

func (a Asc) Less(i, j int) bool {
	return a[i] < a[j]
}

func (a Asc) Swap(i, j int) {
	a[i], a[j] = a[j], a[i]
}

func main() {
	fmt.Println(removeDuplicates([]int{2, 2, 2}))
}

func removeDuplicates(nums []int) int {
	sort.Sort(Asc(nums))

	for i := len(nums) - 1; i > 0; i-- {
		if nums[i-1] == nums[i] {
			nums = append(nums[:i], nums[i+1:]...)
		}
	}

	return len(nums)
}
