package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P914_X_of_a_kind_in_a_Deck_of_Cards {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5, 6};
        System.out.println(hasGroupsSizeX(arr));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : deck) {
            int value = map.getOrDefault(e, 0);
            map.put(e, value + 1);
        }
        int min = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (min == 0 || min > value) min = value;
        }
        List<Integer> candidate = new ArrayList<>();
        for (int i = 2; i <= min; i++) {
            if (min % i == 0) {
                candidate.add(i);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            for (int i = 0; i < candidate.size(); i++) {
                if (value % candidate.get(i) != 0) {
                    candidate.remove(i);
                    i--;
                }
            }
            if (candidate.size() <= 0) return false;
        }
        return true;
    }

}