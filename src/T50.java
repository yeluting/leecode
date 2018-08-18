/**
 * Created by YLT on 2018/8/1.
 */
public class T50 {
    public double myPow(double x, int n) {
        boolean flag = true;
        if (n < 0){
            n = -n;
            flag = false;
        }

        double result = 1;
        double temp = x;
        for (int i = 0; i < 32; i ++){
            if ((n & 1) == 1) result = result * x;
            n = n >> 1;
            temp = temp * temp;
        }
        return result;
    }

    public double myPow1(double x, int n) {
        if (n > 0){
            return digui(x,n);
        }else {
            return 1/digui(x,n);
        }
    }
    public double digui(double x, int n){
        if (n == 0) return 1;
        if (n == 1) return x;
        double result = digui(x,n/2);
        return n%2==0?result * result:result * result * x;
    }

}
