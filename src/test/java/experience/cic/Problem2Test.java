package experience.cic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class Problem2Test {

    @Test
    void deleteProducts() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 1, 2, 2);
        System.out.println(Problem2.deleteProducts(ids, 3));
    }
}