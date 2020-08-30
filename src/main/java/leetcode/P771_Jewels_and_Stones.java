package leetcode;

public class P771_Jewels_and_Stones {

    public int numJewelsInStones(String J, String S) {
        int answer = 0;
        for (int i = 0, len = S.length(); i < len; i++) {
            if (J.indexOf(S.charAt(i)) != -1) {
                answer++;
            }
        }
        return answer;
    }

}
