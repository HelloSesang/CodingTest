package topcoder;

import java.util.HashMap;
import java.util.Map;

/*
	사람들은 2가지 주제에만 관심이 있고, 관심 없는 주제로 이야기하는 것을 싫어한다.
	파티를 하는데 초대된 사람 모두가 공통의 흥미 있는 주제가 있을 때 파티가 즐겁다.
	즐거운 파티가 되기 위해 초대할 수 있는 최대 사람 수를 반환하라.
*/
public class InterestingParty {

    public static int getMaximumNumber(String[] first, String[] second) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0, len = first.length; i < len; i++) {
            map.put(first[i], map.getOrDefault(first[i], 0) + 1);
            map.put(second[i], map.getOrDefault(second[i], 0) + 1);
        }

        int max = 0;
        for (String str : map.keySet()) {
            max = Math.max(map.get(str), max);
        }

        return max;
    }

}
