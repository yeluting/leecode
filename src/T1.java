import java.util.HashMap;
import java.util.Map;



public class T1 {
    public int[] twoSum(int[] nums, int target) {
        int []result = {-1,-1};
        HashMap<Integer,Integer> pre = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            if(pre.containsKey(target - nums[i])){
                return new int[]{pre.get(target - nums[i]),i};
            }
            pre.put(nums[i],i);
        }
        return result;
    }
}
