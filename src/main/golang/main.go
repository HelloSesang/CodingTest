package main

import "fmt"

func main() {
	arr := []int {1,3,2,4}
	fmt.Println(SelectionSort(arr))
}

func SelectionSort(arr []int) []int {

	for i := 0; i < len(arr) - 1; i++ {
		minIdx := i
		for j := i + 1; j < len(arr); j++ {
			if (arr[minIdx] > arr[j]) {
				minIdx = j
			}
		}
		arr[i], arr[minIdx] = arr[minIdx], arr[i]
	}

	return arr
}


