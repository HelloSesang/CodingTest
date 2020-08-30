package experience.cic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Problem1Test {

    @Test
    void maxStreak() {
        List<String> list = new ArrayList<>();
        list.add("Y");
        System.out.println(Problem1.maxStreak(1, list));
    }
}