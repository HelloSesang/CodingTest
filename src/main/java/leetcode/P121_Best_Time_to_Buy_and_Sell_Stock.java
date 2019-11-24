package leetcode;

public class P121_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, max = 0;
		for (int price: prices) {
			min = Math.min(min, price);
			max = Math.max(price - min, max);
		}
		return max;
	}
}
