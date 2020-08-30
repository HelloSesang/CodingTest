package experience.stcompany;

/*
	배열 A의 길이는 1 ~ 8
	배열 A의 요소는 영문 소문자로 이루어진다.
	중복된 문자가 존재하지 않는 문자열을 서로 합칠 수 있다.
	문자열을 더한 최종 길이는 100을 넘지 않는다.
	더할 수 있는 문자열이 없다면 0을 반환한다.
	A 배열에 존재하는 문자열을 조건에 맞게 더한 결과 중 그 길이가 가장 긴 것의 길이를 반환하라.
*/

import java.util.*;

public class Problem1_retry {

    public int solution(String[] A) {
        // answer 변수를 생성하고 0으로 초기화한다.
        int answer = 0;

        // 배열 A를 오름차순으로 정렬한다.
        Arrays.sort(A);

        // 반복문으로 배열 A의 모든 순열을 하나씩 만든다.
        do {
            // 더한 문자열을 저장할 변수
            StringBuilder sb = new StringBuilder();

            // 문자열 중복 체크를 위한 Set
            Set<Character> set = new HashSet<>();

            // 반복문으로 배열 A의 1번 인덱스부터 마지막 요소까지 순차접근한다.
            for (int i = 0, len = A.length; i < len; i++) {
                // 문자열을 합친다.
                sb.append(A[i]);
                // 합친 문자열에 중복 문자가 존재하는지 확인하기 위해 Set에 합친 문자들을 넣는다.
                for (Character c : A[i].toCharArray()) {
                    set.add(c);
                }
                // 중복 문자가 존재하는 경우
                if (sb.toString().length() > set.size()) {
                    // answer의 값보다 중복 존재하기 전의 문자열의 길이가 긴 경우
                    if (answer < sb.toString().length() - A[i].length()) {
                        // answer의 값을 더 긴 값으로 변경해준다.
                        answer = sb.toString().length() - A[i].length();
                    }
                    // 이번 순열은 끝났으니 탈출한다.
                    break;
                }
            }
        } while (nextPermutation(A));

        // 최종적으로 얻은 가장 긴 문자열의 길이를 반환한다.
        return answer;
    }

    private boolean nextPermutation(String[] sequence) {
        int i = sequence.length - 1;

        // 다음 순열을 만들기 위해 교체해야 할 첫 번째 위치를 찾는다.
        while (i > 0 && sequence[i - 1].compareTo(sequence[i]) >= 0) {
            i--;
        }

        // 마지막 순열에 도달했다는 것으로 더 이상의 다음 순열이 없음을 알린다.
        if (i <= 0) {
            return false;
        }

        // 다음 순열을 만들기 위해 교체해야 할 두 번째 위치를 찾는다.
        int j = sequence.length - 1;
        while (sequence[j].compareTo(sequence[i - 1]) <= 0) {
            j--;
        }

        // 찾는 두 위치의 값을 서로 교환한다.
        String temp = sequence[i - 1];
        sequence[i - 1] = sequence[j];
        sequence[j] = temp;

        // 뒷자리를 오름차순 정렬해서 다음 순열을 완성한다.
        j = sequence.length - 1;
        while (i < j) {
            temp = sequence[i];
            sequence[i] = sequence[j];
            sequence[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
