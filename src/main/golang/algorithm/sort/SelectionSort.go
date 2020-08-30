package sort

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