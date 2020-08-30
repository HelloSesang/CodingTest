package experience.ncompany;

/*
	사탕 획득 카드 게임
	카드를 한 장씩 뽑는다.
	카드에 정의된 명령을 실행한다.
	사탕을 최대한 많이 획득해야 한다.
	플레이어와 팔로워가 존재
	카드의 종류는 A, J, Q, K
	A 뽑은 플레이어가 사탕 획득
	J 뽑은 플레이어 양옆이 사탕 획득
	Q 모든 플레이어 사탕 획득
	K 팔로워 지정 사탕 획득 없음
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 플레이어 수
        int playerCount = Integer.parseInt(br.readLine());

        // 뽑은 카드
        String[] cards = br.readLine().split(" ");

        // 팔로워 저장 그래프 초기화
        List<Integer>[] follower = new ArrayList[playerCount];
        Arrays.fill(follower, new ArrayList<>());

        // 정답을 담을 배열
        int[] answer = new int[playerCount];


        for (int i = 0; i < cards.length; i++) {
            int curPlayer = i % playerCount;
            switch (cards[i]) {
                case "A":
                    answer[i]++;
                    break;
                case "J":
                    answer[i - 1 < 0 ? playerCount - 1 : i - 1]++;
                    answer[i + 1 >= playerCount ? 0 : i + 1]++;
                    break;
                case "Q":
                    for (int j = 0; j < playerCount; j++) {
                        answer[i]++;
                    }
                    break;
                case "K":
                    break;
            }
        }

    }

}
