package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class P728_Self_Dividing_NumbersTest {

	@Test
	public void selfDividingNumbers() {
		P728_Self_Dividing_Numbers obj = new P728_Self_Dividing_Numbers();
		List<Integer> result = obj.selfDividingNumbers(1, 22);
		System.out.println(result);
	}
}