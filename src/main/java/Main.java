import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = {1,3,4,2};
        System.out.println(Arrays.toString(main.insertionSort(arr)));
    }

    private int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (key < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    break;
                }
            }
        }

        return arr;
    }

}