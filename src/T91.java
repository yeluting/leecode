/**
 * Created by YLT on 2018/8/2.
 */
public class T91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int [] dp = new int[length+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1:0;
        for (int i = 2; i <= length; i ++){
            int first = Integer.parseInt(s.substring(i-1,i));
            int seconde = Integer.parseInt(s.substring(i-2,i));
            if (first >= 1 && first <= 9){
                dp[i] += dp[i-1];
            }
            if (seconde >=10 && seconde <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[length];
    }
}
