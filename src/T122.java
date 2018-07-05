/**
 * Created by YLT on 2017/11/1.
 */
public class T122 {
 /*   public int maxProfit(int[] prices) {
        int profit = 0,length = prices.length;
        int now = 0,next = 1;
        while (next < length){
            if(prices[now] < prices[next]){
                profit += prices[next] - prices[now];
            }
                now = next;
                next ++;
        }
        return profit;
    }*/

    /*public int maxProfit(int[] prices) {
        int profit = 0, length = prices.length;
        int now = 0;
        int next = 1;
        while (next < length) {
            if (prices[now] < prices[next]) {
                do {
                    next++;
                } while (next < length && prices[next] > prices[next - 1]);
                profit = profit + prices[next - 1] - prices[now];
            }
            now = next;
            next++;
        }
        return profit;
    }*/

    public int maxProfit(int[] prices) {
        int profit = 0, length = prices.length;
        int now = 0;
        int max = prices[0];
        int min = prices[0];
        while (now < length - 1) {
            while (now < length - 1 && prices[now] > prices[now + 1]){
            now ++;
           }
            min = prices[now];
            while(now < length - 1 && prices[now] < prices[now + 1]){
                now ++;
            }
            max = prices[now];
           profit += max - min;
        }
        return profit;
    }
}
