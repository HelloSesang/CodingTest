package etc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {
        String input = "tact coa";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            int count = map.getOrDefault(input.charAt(i), 0);
            map.put(input.charAt(i), count + 1);
        }

        Set<Character> set = map.keySet();

        int count = 0;
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            if (map.get(itr.next()) % 2 != 0) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }

    }

}
