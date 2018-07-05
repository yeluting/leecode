/**
 * Created by YLT on 2018/5/21.
 */
public class T287 {
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int n = length - 1;
        int begin = 1, end = n;


        while (end - begin >= 0) {
            int mid = (begin+end)/2;
            int count = count(begin,mid,nums,length);
            if (end == begin){
                if (count > 1){
                    return begin;
                }
            }
            if (count > mid - begin + 1){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public int count(int begin, int end, int[] nums, int length){
        if (nums == null || length == 0){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < length; i ++){
            if (nums[i] >= begin && nums[i] <= end){
                count++;
            }
        }
        return count;
    }
}
