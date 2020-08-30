package programmers;

public class 자릿수_더하기 {

    public static void main(String[] args) {
        자릿수_더하기 obj = new 자릿수_더하기();
        int answer = obj.solution(123);
        System.out.println(answer);
    }

    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

}
