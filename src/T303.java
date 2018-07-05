/**
 * Created by YLT on 2018/5/17.
 */
public class T303 {
    private int []result;
    public T303(int[] nums) {
        int length = nums.length;
        int result[] = new int[length+1];
        result[0] = 0;
        for (int a = 0; a < length; a ++){
            result[a+1] += result[a] + nums[a+1];
        }
    }

    public int sumRange(int i, int j) {
        return result[j+1] - result[i];
    }
}
