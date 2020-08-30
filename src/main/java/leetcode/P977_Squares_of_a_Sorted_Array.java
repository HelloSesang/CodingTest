package leetcode;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class P977_Squares_of_a_Sorted_Array {

    public int[] sortedSquares(int[] A) {
        int[] result = Arrays.stream(A).map(operand -> operand * operand).toArray();
        Arrays.sort(result);

        return result;
    }

}
