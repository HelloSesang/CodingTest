package programmers;

public class 시저_암호 {

	public static void main(String[] args) {
		시저_암호 obj = new 시저_암호();
		String answer = obj.solution("a B z", 4);
		System.out.println(answer);
	}

	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = s.length(); i < len; i++) {
			char now = s.charAt(i);
			if (now != ' ') {
				now += n;
				if (s.charAt(i) <= 'Z' && now > 'Z') {
					now = (char) ('A' + (now - 'Z' -1));
				} else if (now > 'z') {
					now = (char) ('a' + (now - 'z' - 1));
				}
			}
			sb.append(now);
		}

		return sb.toString();
	}

}
