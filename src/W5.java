import java.util.Scanner;

/**
 * Created by YLT on 2018/8/10.
 */
public class W5 {
    public static void main(String[] args) {
        W5 w5 =new W5();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        while (num >0){
            int count = in.nextInt();
            int []nums = new int[count];
            for (int i = 0; i < count; i ++){
                nums[i] = in.nextInt();
            }
            w5.panduan(nums);
            num--;
        }
    }

    public void panduan(int[] nums){
        int length = nums.length;
        int count = 0;
        int count2 = 0;
        int count4 = 0;
        for (int i = 0; i < length; i ++){
            if (nums[i]%4 ==0){
                count4++;
            }else if (nums[i]%2 ==0){
                count2++;
            }else {
                count++;
            }
        }
        if (count4 + 1 >= count + count2%2){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
