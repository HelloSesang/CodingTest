console.log(insertionSort([1,3,2,4]));

function insertionSort(arr) {
    for (let i = 1; i < arr.length; i++) {
        let target = arr[i];
        for (let j = i - 1; j >= 0; j--) {
            if (target < arr[j]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            } else {
                break;
            }
        }
    }
    return arr;
}