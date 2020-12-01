package leetcode;

public class P1662_Check_If_Two_String_Arrays_are_Equivalent {

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (String str : word1) {
			sb1.append(str);
		}

		for (String str : word2) {
			sb2.append(str);
		}

		return sb1.toString().equals(sb2.toString());
	}

}
