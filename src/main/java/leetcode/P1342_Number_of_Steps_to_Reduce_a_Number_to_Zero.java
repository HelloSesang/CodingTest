package leetcode;

public class P1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {

    public static void main(String[] args) {
        P1342_Number_of_Steps_to_Reduce_a_Number_to_Zero obj = new P1342_Number_of_Steps_to_Reduce_a_Number_to_Zero();
        obj.numberOfSteps(5);
    }

    public int numberOfSteps(int num) {
        int count = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }

        return count;
    }
}
