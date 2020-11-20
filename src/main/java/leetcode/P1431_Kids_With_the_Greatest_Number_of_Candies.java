package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1431_Kids_With_the_Greatest_Number_of_Candies {

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<>();

		int max = 0;
		for (int count : candies) {
			if (count > max) {
				max = count;
			}
		}

		for (int count : candies) {
			if (count + extraCandies >= max) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}
