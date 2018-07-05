/**
 * Created by apple on 2018/6/27.
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i ++){
            dp[i] = dp[i-1] > 0?dp[i-1] + nums[i]:nums[i];
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
