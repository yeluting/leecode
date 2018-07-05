/**
 * Created by YLT on 2017/7/11.
 */
public class T283 {
    public static void main(String[] args) {
        T167 t167 = new T167();
        int []a = {2,7,11,15};
        int []end = t167.twoSum(a,9);
        System.out.println(end[0]+";"+end[1]);
    }
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros
    public void moveZeroes1(int[] nums) {
        int index = 0;
        for (int num:nums
             ) {
            if(num!=0){
                nums[index++] = num;
            }
        }
        while(index < nums.length){
            nums[index++]=0;
        }
    }

    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        if(nums.length == 1){
            return;
        }
        for (int i = 0;i < nums.length; i++
                ) {
            if(nums[i] == 0){
                zeroNum ++;
            }else if(zeroNum!=0) {
                nums[i - zeroNum]=nums[i];
                nums[i] = 0;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int count = 0;
        for(int i = 0; i < length; i ++){
            if(nums[i] != 0){
                nums[count++] = nums[i];
            }
        }
        for(; count < length; count ++){
            nums[count] = 0;
        }
    }
}
