package leetcode

import (
	"sort"
)

type ByLen []string

func (a ByLen) Len() int {
	return len(a)
}

func (a ByLen) Less(i, j int) bool {
	return len(a[i]) < len(a[j])
}

func (a ByLen) Swap(i, j int) {
	a[i], a[j] = a[j], a[i]
}

func longestCommonPrefix(strs []string) string {
	sort.Sort(ByLen(strs))

	prefixLen := len(strs[0])
	for i := 1; i < len(strs); i++ {
		for j := 0; j < prefixLen; j++ {
			if strs[0][j] != strs[i][j]{
				prefixLen = j
			}
		}
	}

	return strs[0][:prefixLen]
}