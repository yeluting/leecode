import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YLT on 2017/11/16.
 */
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i ++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1, end = length - 1;
            while (j < end){
                int sum = nums[i] + nums[j] + nums[end];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[end]));
                    while (++j < end && nums[j] == nums[j-1]);
                    while (--end > j && nums[end] == nums[end+1]);
                }else if (sum < 0){
                    while (++j < end && nums[j] == nums[j-1]);
                }else {
                    while (--end > j && nums[end] == nums[end+1]);
                }
            }
        }
        return result;
    }
}
