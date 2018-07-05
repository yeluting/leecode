import java.util.Arrays;

/**
 * Created by YLT on 2018/6/13.
 */
public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int delta = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        for (int i = 0; i < length; i ++){
            int j = i + 1, end = length - 1;
            while (j < end){
                int temp = nums[i] + nums[j] + nums[end];
                if (temp == target){
                    return target;
                }else {
                    int deltaTemp = Math.abs(temp - target);
                    if (delta > deltaTemp){
                        delta = deltaTemp;
                        result = temp;
                    }
                    if (temp < target){
                        j++;
                    }else if (temp > target){
                        end --;
                    }
                }
            }
        }
        return result;
    }
}
