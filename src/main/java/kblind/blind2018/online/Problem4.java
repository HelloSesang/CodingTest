package kblind.blind2018.online;

class Problem4 {

    public static void main(String[] args) {
        Problem4 solution = new Problem4();
        int[] arr = {3, 1, 2};
        System.out.println(solution.solution(arr, 5));
    }

    public int solution(int[] food_times, long k) {
        // k / food_times.length; 몫을 구한다.
        // k %= food_times.length;
        // food_times 요소마다 몫을 모두 뺀다.
        // 0부터 k만큼 돈다. -값만큼 k를 추가한다.
        // 멈추는 곳의 인덱스를 반환한다.
        long sum = 0;
        for (int i = 0, len = food_times.length; i < len; i++) {
            sum += food_times[i];
        }
        if (sum <= k) {
            return -1;
        }

        long repeatCnt = k / food_times.length;
        k %= food_times.length;

        for (int i = 0, len = food_times.length; i < len; i++) {
            food_times[i] -= repeatCnt;
        }

        for (int i = 0, len = food_times.length; i < len; i++) {
            if (food_times[i] < 0) k += -food_times[i];
        }

        int index = 0;
        while (k-- > 0) {
            if (food_times[index] > 0) {
                food_times[index]--;
            } else {
                k++;
            }
            index = index + 1 >= food_times.length ? 0 : index + 1;
        }
        return index + 1;
    }

}