/**
 * Created by YLT on 2018/5/17.
 */
public class T217 {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                if (nums[temp] == temp) {
                    return true;
                } else {
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
        }
        return false;
    }
}
