package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class P1122_Relative_Sort_ArrayTest {

	@Test
	public void relativeSortArray() {
		P1122_Relative_Sort_Array obj = new P1122_Relative_Sort_Array();
		int[] input1 = new int[] {2,3,1,3,2,4,6,7,9,2,19};
		int[] input2 = new int[] {2,1,4,3,9,6};
		assertThat(obj.relativeSortArray(input1, input2)).containsExactly(2,2,2,1,4,3,3,9,6,7,19);
	}
}