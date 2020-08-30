package programmers;

public class 콜라츠_추측 {

    public int solution(int num) {
        return getRepeatCount(num, 0);
    }

    private int getRepeatCount(long num, int nowCount) {
        if (nowCount >= 500) {
            return -1;
        }

        if (num == 1) {
            return nowCount;
        }

        if (num % 2 == 0) {
            num /= 2;
        } else {
            num = num * 3 + 1;
        }

        return getRepeatCount(num, nowCount + 1);
    }

}
