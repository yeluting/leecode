/**
 * Created by YLT on 2017/11/1.
 */
public class T121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else {
                if(prices[i] - minPrice > profit){
                    profit = prices[i] - minPrice;
                }
            }
        }
        return profit;
    }
}
