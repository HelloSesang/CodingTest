package main

import "fmt"

func main() {
	arr := []int {1,3,2,4}
	fmt.Println(InsertionSort(arr))
}

func InsertionSort(arr []int) []int {
	for i := 1; i < len(arr); i++ {
		key := arr[i]
		for j := i - 1; j >= 0; j-- {
			if key < arr[j] {
				temp := arr[j]
				arr[j] = arr[j + 1]
				arr[j + 1] = temp
			} else {
				break;
			}
		}
	}
	return arr
}


