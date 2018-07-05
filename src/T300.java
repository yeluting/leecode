/**
 * Created by YLT on 2018/5/17.
 */
public class T300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length ==0){
            return 0;
        }
        int [] dp = new int[length];
        for (int i = 0; i < length; i ++){
            dp[i] = 1;
        }
        int max = dp[0];
        for (int i = 1; i < length; i ++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
