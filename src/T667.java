/**
 * Created by YLT on 2017/8/30.
 */
public class T667 {
    public int[] constructArray(int n, int k) {
        int [] result = new int [n];
        int delta = k;
        result[0] = 1;
        for (int i = 1;i <= k; i ++){
            if(i % 2 == 1){
                result[i] = result[i - 1] + delta;
            }else {
                result[i] = result[i - 1] - delta;
            }
            delta--;
        }
        for(int i = k + 1;i < n; i++){
            result[i] = i + 1;
        }
        return result;
    }
}
