package baekjoon;

/*
	부등호 배열이 존재한다.
	부등호 앞뒤에 0부터 9까지의 정수를 중복없이 넣을 수 있다.
	부등호 조건을 만족할 때 부등호를 제거하면 숫자가 생성된다.
	부등호 조건을 만족하는 숫자 최솟값과 최댓값을 구하라.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2529_부등호 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 부등호 갯수와 부등호 입력 받기
        int signCount = Integer.parseInt(br.readLine());
        String[] inequalitySigns = br.readLine().split(" ");

        // 최댓값, 최솟값을 저장할 변수 선언
        String min = String.valueOf(Long.MAX_VALUE);
        String max = "0";

        // 순열을 만들어낼 0~9까지의 숫자 배열
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 반복문으로 1~9로 만들 수 있는 모든 순열을 생성한다.
        do {
            boolean flag = true;
            // 현재 만들어진 순열에 대해 부등호가 만족하는지 확인한다.
            for (int i = 1; i <= signCount; i++) {
                switch (inequalitySigns[i - 1]) {
                    case "<":
                        flag = numbers[i - 1] < numbers[i];
                        break;
                    case ">":
                        flag = numbers[i - 1] > numbers[i];
                        break;
                }
                if (!flag) {
                    break;
                }
            }

            // 만족하는 경우
            if (flag) {
                StringBuilder sb = new StringBuilder();
                // 숫자를 생성한다.
                for (int i = 0; i <= signCount; i++) {
                    sb.append(numbers[i]);
                }
                // min보다 작으면 min에 대입한다.
                if (Long.parseLong(min) > Long.parseLong(sb.toString())) {
                    min = sb.toString();
                }
                // max보다 크면 max에 대입한다.
                if (Long.parseLong(max) < Long.parseLong(sb.toString())) {
                    max = sb.toString();
                }
            }
        } while (nextPermutation(numbers));

        // max를 출력한다.
        System.out.println(max);
        // min을 출력한다.
        System.out.println(min);
    }

    private static boolean nextPermutation(int[] sequence) {
        int i = sequence.length - 1;

        // 다음 순열을 만들기 위해 교체해야 할 첫 번째 위치를 찾는다.
        while (i > 0 && sequence[i - 1] >= sequence[i]) {
            i--;
        }

        // 마지막 순열에 도달했다는 것으로 더 이상의 다음 순열이 없음을 알린다.
        if (i <= 0) {
            return false;
        }

        // 다음 순열을 만들기 위해 교체해야 할 두 번째 위치를 찾는다.
        int j = sequence.length - 1;
        while (sequence[j] <= sequence[i - 1]) {
            j--;
        }

        // 찾는 두 위치의 값을 서로 교환한다.
        int temp = sequence[i - 1];
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
