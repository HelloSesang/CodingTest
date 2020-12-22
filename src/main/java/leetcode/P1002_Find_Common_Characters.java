package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1002_Find_Common_Characters {

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();

        List<Map<Character, Integer>> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(i, new HashMap<>());
        }

        for (int i = 0; i < A.length; i++) {
            for (Character ch : A[i].toCharArray()) {
                Map<Character, Integer> map = list.get(i);
                int count = map.getOrDefault(ch, 0);
                map.put(ch, count + 1);
            }
        }

        Map<Character, Integer> map = list.get(0);
        for (Character ch : map.keySet()) {
            int count = map.get(ch);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getOrDefault(ch, 0) < count) {
                    count = list.get(i).getOrDefault(ch, 0);
                }
            }
            for (int i = 0; i < count; i++) {
                result.add(ch.toString());
            }
        }

        return result;
    }

}
