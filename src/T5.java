import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T5 {
    public String longestPalindrome(String s)  {
        int length = s.length();
        int[][] dp = new int[length][length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < length; i ++){
            dp[i][i] = 1;
        }
        for (int i = 1; i < length; i ++){
            for (int j = 0; j < length - i; j ++){
                if (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1] == 1)){
                    dp[j][j+i] = 1;
                    index1 = j;
                    index2 = j + i;
                }
            }
        }
        return s.substring(index1,index2+1);
    }
}
