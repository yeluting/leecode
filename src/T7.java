/**
 * Created by YLT on 2017/11/6.
 */
public class T7 {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0){
            rev = rev * 10 + x%10;
            x = x / 10;
            if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int) rev;
    }
}
