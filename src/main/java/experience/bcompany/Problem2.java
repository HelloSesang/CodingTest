package experience.bcompany;

public class Problem2 {

	/*
	 * Complete the 'programmerStrings' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts STRING s as parameter.
	 */

	public static int programmerStrings(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}

		int leftEndIndex = findLeftProgrammerStringEndIndex(s);
		int rightStartIndex = findRightProgrammerStringStartIndex(s);
		int betweenCharCount = rightStartIndex - leftEndIndex - 1;
		if (betweenCharCount < 0) {
			return 0;
		}
		return betweenCharCount;
	}

	static int findLeftProgrammerStringEndIndex(String s) {
		Condition condition = new Condition();
		for (int i = 0, len = s.length(); i < len; i++) {
			if (condition.isSatisfy(s.charAt(i))) {
				return i;
			}
		}
		return 0;
	}

	static int findRightProgrammerStringStartIndex(String s) {
		Condition condition = new Condition();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (condition.isSatisfy(s.charAt(i))) {
				return i;
			}
		}
		return 0;
	}

	static class Condition {

		private int pCount;
		private int rCount;
		private int oCount;
		private int gCount;
		private int aCount;
		private int mCount;
		private int eCount;
		private int totalCount;

		public Condition() {
			pCount = 1;
			rCount = 3;
			oCount = 1;
			gCount = 1;
			aCount = 1;
			mCount = 2;
			eCount = 1;
			totalCount = 10;
		}


		public boolean isSatisfy(char ch) {
			switch (ch) {
				case 'p' :
					pCount--;
					totalCount--;
					break;
				case 'r' :
					rCount--;
					totalCount--;
					break;
				case 'o' :
					oCount--;
					totalCount--;
					break;
				case 'g' :
					gCount--;
					totalCount--;
					break;
				case 'a' :
					aCount--;
					totalCount--;
					break;
				case 'm' :
					mCount--;
					totalCount--;
					break;
				case 'e' :
					eCount--;
					totalCount--;
					break;
			}

			return totalCount <= 0;
		}
	}
}