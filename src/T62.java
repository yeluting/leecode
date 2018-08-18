/**
 * Created by apple on 2018/6/27.
 */
public class T62 {
    public int uniquePaths(int m, int n) {
        int len = m + n -2;
        int result = 1;
        int temp = 1;
        for (int i = n; i <= m + n - 2; i ++){
            result = result * i;
        }
        for (int i = 1; i <= m - 1; i++){
            temp = temp * i;
        }
        return result/temp;
    }

    public int uniquePaths0(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i ++){
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
