package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class P973_K_Closest_Points_to_OriginTest {

    @Test
    public void kClosest() {
        int[][] input1 = {{3, 3}, {5, -1}, {-2, 4}};
        int input2 = 2;

        P973_K_Closest_Points_to_Origin obj = new P973_K_Closest_Points_to_Origin();
        int[][] answer = obj.kClosest(input1, input2);

        assertThat(answer).containsExactly(new int[]{3, 3}, new int[]{-2, 4});
    }
}