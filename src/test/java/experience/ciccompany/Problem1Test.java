package experience.ciccompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Problem1Test {

    private Problem1 problem1;

    @BeforeEach
    void before() {
        problem1 = new Problem1();
    }

    @Test
    void findNumber() {
        List<Integer> arr = Arrays.asList(2, 3, 1);
        System.out.println(Problem1.findNumber(arr, 5));
    }
}