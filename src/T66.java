/**
 * Created by YLT on 2018/8/1.
 */
public class T66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int flag = 1;
        int end = length - 1;
        while (flag == 1){
            int sum = digits[end] + flag;
            digits[end] = sum%10;
            flag = sum/10;
            end --;
        }
        if (end == -1 && flag == 1){
            int [] result = new int[length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
