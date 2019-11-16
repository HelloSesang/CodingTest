package topcoder;

public class KiwiJuice {

	public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int i = 0, len = fromId.length; i < len; i++) {
			int fromIndex = fromId[i];
			int toIndex = toId[i];
			int rest = capacities[toIndex] - bottles[toIndex];

			// toBottle의 남은 용량이 fromBottle에 들어있는 양보다 큰 경우
			if (bottles[fromIndex] <= rest) {
				// toBottle은 기존의 양 + fromBottle의 양이 된다.
				bottles[toIndex] = bottles[toIndex] + bottles[fromIndex];
				// fromBottle은 0이 된다.
				bottles[fromIndex] = 0;
			}

			// toBottle의 남은 용량이 fromBottle에 들어있는 양보다 작은경우
			if (bottles[fromIndex] > rest) {
				// fromBottle의 양은 rest 만큼 줄어든다.
				bottles[fromIndex] -= rest;
				// toBottle의 양은 capacities와 같아진다.
				bottles[toIndex] = capacities[toIndex];
			}
		}

		return bottles;
	}
}
