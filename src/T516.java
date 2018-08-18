/**
 * Created by YLT on 2018/8/1.
 */
public class T516 {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        int result = 0, index2 = 0;
        for (int i = 0; i < length; i ++){
            dp[i][i] = 1;
        }
        for (int i = 1; i < length; i ++){
            for (int j = 0; j < length - i; j ++){
                if (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1] == 1)){
                    dp[j][j+i] = 1;
                   result = i;
                }
            }
        }
        return result;
    }
}
