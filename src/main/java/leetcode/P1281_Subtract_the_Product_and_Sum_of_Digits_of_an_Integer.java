package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {

	public int subtractProductAndSum(int n) {
		List<Integer> numbers = new ArrayList<>();
		int multiple = 1;
		int sum = 0;

		while(n > 0) {
			int number = n % 10;
			multiple *= number;
			sum += number;
			n /= 10;
		}

		return multiple - sum;
	}

}
