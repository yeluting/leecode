/**
 * Created by YLT on 2017/9/7.
 */
public class T421 {
    /*T421 chileren[];
    public T421(){
        chileren = new T421[2];
    }

    public int findMaximumXOR(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        T421 root = new T421();
        for (int num:nums
             ) {
            T421 curT421 = root;
            for(int i = 31;i >= 0; i--){
                int curBit = (num >>> i) & 1;
                if(curT421.chileren[curBit] == null){
                    curT421.chileren[curBit] = new T421();
                }
                curT421 = curT421.chileren[curBit];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num:nums
             ) {
            T421 curT421 = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i --){
                int curBit = (num >>> i) & 1;
                if(curT421.chileren[curBit ^ 1] != null){
                    curSum += (1 << i);
                    curT421 = curT421.chileren[curBit^1];
                }else {
                    curT421 = curT421.chileren[curBit];
                }
                max = Math.max(curSum,max);
            }
        }
        return max;
    }*/

    public int findMaximumXOR(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j ++){
                if(max < (nums[i] ^ nums[j])) max = nums[i] ^ nums[j];
            }
        }
        return max;
    }




}
