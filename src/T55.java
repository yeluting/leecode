/**
 * Created by apple on 2018/6/27.
 */
public class T55 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i ++){
            if (i > max || max >= length - 1){
                break;
            }
            max = Math.max(max,nums[i] + i);
        }
        return max >= length - 1;
    }

    public boolean canJump1(int[] nums) {
        int length = nums.length;
        int [] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i ++){
            if (i <= dp[i-1]){
                dp[i] = Math.max(dp[i-1],nums[i] + i);
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[length-1] >= length - 1;
    }
}
