package programmers;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 반복문으로 skill_trees 배열에 순차접근한다.
        for (String e : skill_trees) {
            // beforeIndex 변수를 선언하고 0을 대입한다.
            int beforeIndex = 0;
            // flag = true;
            boolean flag = true;

            // 반복문으로 skill의 각 문자에 접근
            for (int i = 0; i < skill.length(); i++) {
                char now = skill.charAt(i);
                // 현재 문자가 skill_trees의 현재 요소의 몇 번 인덱스에 있는지 찾는다.
                int idx = e.indexOf(now);

                // 현재 문자가 skill_trees의 요소에 없는 경우
                if (idx == -1) {
                    // 이후 스킬을 익히지 못하도록 -1로 설정한다.
                    beforeIndex = -1;
                    // 다음으로 넘어간다.
                    continue;
                }

                // 선행 스킬을 익히지 않았는데 후행 스킬을 익히려고 하거나, 후행 스킬을 선행 스킬보다 먼저 배우려고하는 경우
                if ((beforeIndex == -1 && idx != -1) || idx < beforeIndex) {
                    // flag를 false로 변경한다.
                    flag = false;
                    // break로 탈출한다.
                    break;
                    // 찾은 인덱스가 beforeIndex 변수의 값보다 큰 경우
                } else {
                    // beforeIndex에 찾은 인덱스 위치를 넣는다.
                    beforeIndex = idx;
                }
            }

            // 정상인 경우
            if (flag) {
                // 정답의 수를 하나 추가한다.
                answer++;
            }
        }

        // 최종 결과를 반환한다.
        return answer;
    }

}
