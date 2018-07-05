/**
 * Created by YLT on 2017/8/30.
 */
public class T665 {
    public boolean checkPossibility1(int[] nums) {
        int total = 0;
        for(int i = 0; i <nums.length - 1; i ++){
            if(nums[i + 1] < nums[i]){
                total ++;
                if((total > 1) ){
                    return false;
                    //提高后者大小或者减少自身大小
                }else if ((i + 2 < nums.length && nums[i] > nums[i + 2])&&(i - 1 >= 0 && nums[i-1] > nums[i + 1])){
                    return false;
                }
            }
        }
        return true;
    }
}
