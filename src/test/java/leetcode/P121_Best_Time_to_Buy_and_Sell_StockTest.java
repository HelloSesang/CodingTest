package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class P121_Best_Time_to_Buy_and_Sell_StockTest {

	@Test
	void maxProfit() {
		P121_Best_Time_to_Buy_and_Sell_Stock obj = new P121_Best_Time_to_Buy_and_Sell_Stock();
		assertThat(obj.maxProfit(new int[] {7,1,5,3,6,4})).isEqualTo(5);
	}
}