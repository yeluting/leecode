/**
 * Created by apple on 2018/6/27.
 */
public class T63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        int [][] dp = new int[height][width];
        for (int i = 0; i < height; i ++){
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                for (int j = i; j < height; j ++){
                    dp[j][0] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < width; i ++){
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }else {
                for (int j = i; j < width; j ++){
                    dp[0][j] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < height; i ++){
            for (int j = 1; j < width; j ++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[height-1][width - 1];
    }
}
