package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1002_Find_Common_Characters {

    public List<String> commonChars(String[] A) {
        List<String> answer = new ArrayList<>();

        // 공통으로 사용되는 문자의 갯수를 저장하는 배열
        int[] dict = new int[26];

        // 첫 번째 문자열에 나오는 모든 문자의 갯수를 세서 저장
        for (int j = 0; j < A[0].length(); j++) {
            dict[A[0].charAt(j) - 'a']++;
        }

        // 첫 번째를 제외한 나머지 문자열에 순차접근
        for (int i = 1; i < A.length; i++) {
            // 현재 접근한 문자열에 존재하는 문자들의 갯수를 저장하는 배열
            int[] curr = new int[26];

            // 현재 접근한 문자열에 나오는 모든 문자의 갯수를 세서 저장
            for (int j = 0; j < A[i].length(); j++) {
                curr[A[i].charAt(j) - 'a']++;
            }

            // 공통으로 사용되는 문자의 갯수를 저장하는 배열에 저장된 문자 출현 갯수를 출현 횟수가 가장 적은 숫자로 업데이트한다.
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j]) dict[j] = curr[j];
            }
        }

        // 최종적으로 정리된 공통 문자 갯수를 체크해서 정답을 완성한다.
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                answer.add(Character.toString((char) ('a' + i)));
            }
        }

        return answer;
    }

}
