/**
 * Created by YLT on 2018/8/1.
 */
public class T29 {
    public int divide(int dividend, int divisor) {
        long result =  dividel(dividend,divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }
    public long dividel(long dividend, long divisor) {
        boolean flag = dividend<0 != divisor<0;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        if (dividend < divisor) return 0;

        long sum = divisor;
        long count = 1;
        while (sum + sum <= dividend){
            sum+=sum;
            count+=count;
        }
        return flag ? -(count+dividel(dividend-sum,divisor)): count+dividel(dividend-sum,divisor);
    }
}
