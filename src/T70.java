/**
 * Created by apple on 2018/6/27.
 */
public class T70 {
    public int climbStairs(int n) {
        int []dp = new int[n+3];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
