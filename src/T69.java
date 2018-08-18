/**
 * Created by YLT on 2018/8/1.
 */
public class T69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int begin = 1;
        int end = x;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                end = mid -1;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }

    public int mySqrt1(int x) {
        if (x == 0){
            return 0;
        }
        long i = x;
        while (i > x/i){
            i = (i + x/i)/2;
        }
        return Math.toIntExact(i);
    }
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        for (int i = 1; i <= x/i; i ++){
            if (i<= x/i && (i+1)> x/(i+1)){
                return i;
            }
        }
        return -1;
    }
}
