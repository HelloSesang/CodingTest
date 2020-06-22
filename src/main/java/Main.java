
class Solution {
	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
			}
		}
		return max;
	}

	public int maxProfit2(int prices[]) {
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minprice)
				minprice = prices[i];
			else if (prices[i] - minprice > maxprofit)
				maxprofit = prices[i] - minprice;
		}
		return maxprofit;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {7,6,4,3,1};
		System.out.println(solution.maxProfit2(arr));
	}
}