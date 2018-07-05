/**
 * Created by apple on 2018/6/27.
 */
public class T75 {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                swap(nums,i,start ++);
            }else if (nums[i] == 2){
                swap(nums,i,end--);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
