package experience.ciccompany;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1 {

    static String findNumber(List<Integer> arr, int k) {
        arr.sort(Comparator.comparingInt(o -> o));
        System.out.println(arr);
        System.out.println(Collections.binarySearch(arr, k));
        if (Collections.binarySearch(arr, k) < 0) {
            return "NO";
        }
        return "YES";
    }
}
