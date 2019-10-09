package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class P832_Flipping_an_ImageTest {

	@Test
	public void flipAndInvertImage() {
		P832_Flipping_an_Image obj = new P832_Flipping_an_Image();
		int[][] result = obj.flipAndInvertImage(new int[][] {{1,1,0}, {1,0,1}, {0,0,0}});
		for (int[] e : result) {
			System.out.println(Arrays.toString(e));
		}
	}
}