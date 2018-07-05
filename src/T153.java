/**
 * Created by YLT on 2017/11/16.
 */
public class T153 {

    /*public int findMin(int[] nums) {
        for(int i = 0;i < nums.length - 2; i++){
            if(nums[i+1]<nums[i]) return nums[i+1];
        }
        return nums[0];
    }*/

    /*    public int findMin(int[] nums) {
            int begin = 0, end = nums.length - 1;
            while(begin <= end){
                if(nums[begin] <= nums[end]) return nums[begin];
                int mid = (begin + end)/2;
                if(nums[begin] <= nums[mid]){
                    begin = mid + 1;
                }else {
                    end = mid;
                }
            }
            return nums[begin];
        }*/
   /* public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while(begin < end) {
            int mid = begin + (end - begin)/2;
            if(nums[mid] > nums[end]){
                begin = mid + 1;
            }else{
                end = mid;
            }
        }
        return nums[begin];
    }*/
    public int findMin(int[] nums) {
        int begin = 0,end = nums.length - 1;
        while(begin <= end){
            int mid = (begin + end)/2;
            if(nums[begin] < nums[mid]){
                begin = mid + 1;
            }else {
                end = mid;
            }
        }
        return nums[begin];
    }


}
