/**
 * Created by apple on 2018/6/27.
 */
public class T64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int [][] dp = new int[height][width];
        dp[height - 1][width - 1] = grid[height - 1][width - 1];
        for (int i = width - 2; i >= 0; i--){
            dp[height - 1][i] = dp[height - 1][i + 1] + grid[height - 1][i];
        }
        for (int i = height - 2; i >=0; i--){
            dp[i][width - 1] = dp[i+1][width - 1] + grid[i][width - 1];
        }

        for (int i = height - 2; i >= 0; i --){
            for (int j = width - 2; j >= 0; j --){
                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
