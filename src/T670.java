import java.util.Arrays;

/**
 * Created by YLT on 2017/9/7.
 */
public class T670 {
    //错在没有说只能交换相邻的两个数
   /* public int maximumSwap1(int num) {
        char [] numStr = String.valueOf(num).toCharArray();
        for (int i = 0;i < numStr.length - 1;i ++){
            if(numStr[i] < numStr[i + 1]){
                char temp = numStr[i];
                numStr[i] = numStr[i + 1];
                numStr[i + 1] = temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numStr));
    }*/
    public int maximumSwap(int num) {
        char [] nums = String.valueOf(num).toCharArray();
        char [] numStr = String.valueOf(num).toCharArray();
        Arrays.sort(numStr);
        int len = numStr.length;
        for (int i = 0;i < len - 1;i ++){
            if(nums[i] != numStr[len - 1 - i]){
                int j = len;
                do{
                    j --;
                }while(nums[j]!=numStr[len - 1 - i] && j > i);
                char temp = nums[j];
                nums[j] = nums[i];
                nums[i] =temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(nums));
    }

    public static void main(String[] args) {
        T670 t599 = new T670();
        t599.maximumSwap(12);
    }

}
