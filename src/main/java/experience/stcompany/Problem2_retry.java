package experience.stcompany;

/*
	String S는 영문 소문자로 이루어져 있다.
	String S의 길이는 2 ~ 300,000이다.
	인접한 두 문자의 조합을 digram 이라고한다.
	두 digram 사이의 거리는 첫 번째 digram의 첫 문자와 두 번째 digram의 첫 문자 사이의 거리이다.
	문자열 S에서 가장 먼 동일 digram의 길이를 구하는 메소드를 작성하라
	동일 digram이 존재하지 않으면  -1을 반환하라
*/

import java.util.HashMap;
import java.util.Map;

public class Problem2_retry {

    public int solution(String S) {
        // answer 변수를 만들고 -1을 할당한다.
        int answer = -1;

        // digram 정보를 보관할 map 자료구조
        Map<String, DigramInfo> map = new HashMap<>();

        // 반복문을 이용해서 모든 digram에 순차 접근한다.
        for (int i = 1, len = S.length(); i < len; i++) {
            // 현재 접근한 digram 변수
            String nowDigram = S.substring(i - 1, i + 1);

            // Digram 객체 찾기
            DigramInfo digramInfo = map.getOrDefault(nowDigram, null);

            // 처음 접하는 digram인 경우
            if (digramInfo == null) {
                // 객체와 start 값을 설정하고 map에 저장
                map.put(nowDigram, new DigramInfo(i - 1, -1));
                // 처음 접하는 digram이 아닌 경우
            } else {
                // map에 저장된 객체의 length 값을 설정
                digramInfo.setLength((i - 1) - digramInfo.getStart());
            }
        }

        // 반복문을 통해 map에 저장된 모든 value에 접근한다.
        for (String s : map.keySet()) {
            DigramInfo digramInfo = map.get(s);

            // length 값이 answer보다 큰 경우
            if (digramInfo.getLength() > answer) {
                // answer에 length를 대입한다.
                answer = digramInfo.getLength();
            }
        }

        // 최종 결과값을 반환한다.
        return answer;
    }

    class DigramInfo {

        private int start;

        private int length;

        public DigramInfo(int start, int length) {
            this.start = start;
            this.length = length;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }

}
