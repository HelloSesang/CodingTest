package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정수_내림차순으로_배치하기 {

    public long solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add((int) (n % 10));
            n /= 10;
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        for (int e : list) {
            sb.append(e);
        }

        return Long.parseLong(sb.toString());
    }

}
