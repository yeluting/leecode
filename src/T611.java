import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by YLT on 2017/8/31.
 */
public class T611 {

    public static void main(String[] args) {
        T611 t611 = new T611();
        t611.triangleNumber(new int []{2,2,3,4});
    }

    public int triangleNumber1(int[] nums) {
        if(nums.length < 3){
            return 0;
        }
        int total = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i < length - 2; i++){
            for(int j = i + 1; j < length - 1; j ++){
                int sum = nums[i]+ nums[j];
                for(int k = j + 1; k < length; k ++){
                    if(sum > nums[k]){
                        total ++;
                    }else {
                        break;
                    }
                }
            }
        }
        return total;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        for(int i = len - 1; i >= 2 ;i --){
            int left = 0, right = i - 1;
            while (left < right){
                if(nums[right] + nums [left] > nums[i]){
                    res += right - left;
                    right--;
                }else {
                    left ++;
                }
            }
        }
        return res;
    }
}
