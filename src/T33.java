/**
 * Created by apple on 2018/6/26.
 */
public class T33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        int begin = 0, end = length - 1;


        while (begin <= end){
            int mid = (begin + end)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[begin] <= nums[mid]){
                if (nums[begin] <= target && nums[mid] > target){
                    end = mid - 1;
                }else {
                    begin = mid + 1;
                }
            }else {
                if (nums[mid] < target && nums[end] >= target){
                    begin = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        T33 t = new T33();
        int result = t.search(nums,target);
        System.out.println(result);
    }
}
