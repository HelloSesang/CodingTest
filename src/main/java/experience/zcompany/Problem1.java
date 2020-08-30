package experience.zcompany;

public class Problem1 {

    public int[][] solution(int[][] matrix) {
        int n = matrix.length;
        // 정답을 담을 n*n 배열 생성
        int[][] answer = new int[n][n];

        // answer의 각 요소에 접근해서 해당 요소에 담을 값을 계산해서 넣는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 총합을 담을 변수
                int sum = 0;
                // 동일 행에 존재하는 값을 더한다.
                for (int k = 0; k < n; k++) {
                    sum += matrix[i][k];
                }
                // 동일 열에 존재하는 값을 더한다.
                for (int k = 0; k < n; k++) {
                    sum += matrix[k][j];
                }
                // 중복 계산된 값을 차감한다.
                sum -= matrix[i][j];
                // 총합을 answer 배열에 저장한다.
                answer[i][j] = sum;
            }
        }

        // 최종 결과를 반환한다.
        return answer;
    }
}
