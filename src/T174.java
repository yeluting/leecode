/**
 * Created by YLT on 2018/5/17.
 */
public class T174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int length = dungeon[0].length;
        int dp [][] = new int[height][length];

        dp[height - 1][length - 1] = Math.max(1,1 - dungeon[height - 1][length - 1]);
        for (int i = height - 2; i >= 0; i --){
            dp[i][length - 1] = Math.max(1,dp[i+1][length-1] - dungeon[i][length - 1]);
        }

        for (int i = length - 2; i >= 0; i --){
            dp[height - 1][i] = Math.max(1,dp[height - 1][i + 1] - dungeon[height - 1][i]);
        }
        for (int i = height - 2;i >= 0; i --){
            for (int j = length - 2; j >= 0; j --){
                dp[i][j] = Math.max(1,Math.min(dp[i+1][j]- dungeon[i][j], dp[i][j+1]-dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
}
