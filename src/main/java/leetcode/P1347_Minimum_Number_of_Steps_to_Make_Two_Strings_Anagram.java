package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {

    public int minSteps(String s, String t) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            if (count > 0) {
                map.put(ch, count - 1);
            } else {
                result++;
            }
        }

        return result;
    }

}
