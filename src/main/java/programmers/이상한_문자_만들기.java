package programmers;

public class 이상한_문자_만들기 {

    public static void main(String[] args) {
        이상한_문자_만들기 obj = new 이상한_문자_만들기();
        String answer = obj.solution("try  hello         world ");
        System.out.println(answer);
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        // 단어별 인덱스를 확인하기 위한 변수
        int idx = 0;

        // 반복문으로 문자열의 각 문자에 접근
        for (int i = 0, len = s.length(); i < len; i++) {
            // 현재 접근하는 인덱스의 문자 확인
            char now = s.charAt(i);

            // 공백 문자인 경우
            if (now == ' ') {
                // 인덱스를 0으로 초기화한다.
                idx = 0;
                // 단어의 한 문자인 경우
            } else {
                // 단어 내에서 현재 문자의 인덱스에 따라 대소문자 변환 처리를 한다.
                if (idx % 2 == 0 && now >= 'a' && now <= 'z') {
                    // 인덱스가 짝수인 경우 대문자로 변경한다.
                    now = Character.toUpperCase(now);
                } else if (idx % 2 == 1 && now >= 'A' && now <= 'Z') {
                    // 인덱스가 홀수인 경우 소문자로 변경한다.
                    now = Character.toLowerCase(now);
                }

                // 인덱스를 하나 올려준다.
                idx++;
            }

            // 변환이 끝난 문자열 StringBuilder에 추가한다.
            sb.append(now);
        }

        // 완성된 결과 문자열을 반환한다.
        return sb.toString();
    }

}
