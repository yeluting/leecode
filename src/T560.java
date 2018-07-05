import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by YLT on 2017/7/6.
 */
public class T560 {
    /*
    * 给定一个数组，子序列的和等于给定的整数
    * */
    /*
    * two loops (i, j) and test if SUM[i, j] = k. Time complexity O(n^2), Space complexity O(1).
    * */
    public int subarraySum1(int[] nums, int k) {
        int total = 0;
        int num = 0;
        for(int i = 0; i < nums.length;i ++){
            num = nums[i];
            if(num == k){
                total ++;
            }
            for(int j = i + 1; j < nums.length ;j ++){
                num +=nums[j];
                if(num == k){
                    total ++;
                }
            }
        }
        return total;
    }

    /*
    * SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
    * */
    public int subarraySum(int[] nums, int k) {
        int total = 0,sum = 0;
        HashMap<Integer,Integer> temp = new HashMap<>();
        temp.put(0,1);
        for(int i = 0;i < nums.length; i++){
            sum += nums[i];
            if(temp.containsKey(sum - k)){
                total += temp.get(sum - k);
            }
            temp.put(sum,temp.getOrDefault(sum,0) + 1);
        }
        return total;
    }

    public static  void main(String[] args){
        T560 t560 = new T560();
        int [] a = {1,1,1,1,1};
        System.out.println(t560.subarraySum(a,2));
    }
}
