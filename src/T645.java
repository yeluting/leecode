/**
 * Created by YLT on 2017/8/31.
 */
public class T645 {
    public int[] findErrorNums(int[] nums) {
        int []times = new int[nums.length + 1];
        for(int i = 0 ;i < nums.length;i ++){
            times[nums[i]] ++;
        }
        int num1= 0,num2=0;
        for (int i = 1 ;i < nums.length + 1; i ++){
            if(times[i] == 2){
                num1 = i;
            }else if(times[i] == 0){
                num2 = i;
            }
        }
        return new int[]{num1,num2};
    }
}
