/**
 * Created by YLT on 2017/10/27.
 */
public class T27 {
    public static void main(String[] args) {
        T27 t27 = new T27();
        t27.removeElement(new int[]{2},3);
    }
    /*public int removeElement(int[] nums, int val) {
        int i = 0,count = 0,j = nums.length -1;
        while (i <= j){
            while (i < nums.length && nums[i] != val ){
                count ++;
                i ++;
            }
            while ( j >= 0 && nums[j] == val ){
                j --;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return count;
    }*/

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length;){
             if(nums[i] != val){
                 nums[count ++] = nums[i];
             }
        }
        return count;
    }
}
