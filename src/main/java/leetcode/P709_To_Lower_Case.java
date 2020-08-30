package leetcode;

public class P709_To_Lower_Case {

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = str.length(); i < len; i++) {
            char now = str.charAt(i);
            if (now >= 'A' && now <= 'Z') {
                now = Character.toLowerCase(now);
            }
            sb.append(now);
        }
        return sb.toString();
    }

}
