/**
 * Created by YLT on 2018/3/26.
 */
public class T322 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        int coinNum = coins.length;
        for (int i = 1; i < amount + 1; i ++){
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i < amount + 1;i ++){
            for (int j = 0 ; j < coinNum; j ++){
                if (i >= coins[j] && dp[i-coins[j]] !=-1){
                    if (dp[i] == -1 || dp[i] > dp[i-coins[j]]+1){
                        dp[i] = dp[i-coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
