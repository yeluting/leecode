/**
 * Created by YLT on 2017/9/14.
 */
public class T496 {
   /* public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int [] stack = new int[num2Len];
        int [] result = new int[num1Len];

        int j = num2Len - 1,top = 0;
        for(int i = 0; i < num1Len;){
            stack[top ++] = nums2[j --];
            if(stack[top - 1] == nums1[i]){
                do{
                    top --;
                }while (top >= 0 && stack[top] <= nums1[i] );
                if(top == -1){
                    result[i] = -1;
                }else{
                    result[i] = stack[top];
                }
                i++;
                j = num2Len - 1;
                top = 0;
            }
        }
        for(int i = 0 ;i < num1Len;i ++){
            System.out.println(result[i]);
        }
        return result;
    }
*/


    public static void main(String[] args) {
        T496 t167 = new T496();
        t167.nextGreaterElement(new int[]{3, 1, 5, 7, 9, 2, 6}, new int[]{1, 2, 3, 5, 6, 7, 9, 11});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }

        int[] outputArray = new int[nums1.length];

        int maxIntFromNums2 = Integer.MIN_VALUE;

        // find maximum number from nums2
        for (int i = 0; i < nums2.length; i++) {
            if (maxIntFromNums2 < nums2[i])
                maxIntFromNums2 = nums2[i];
        }

        // create map integer array for nums2 array
        int[] mapNums2 = new int[maxIntFromNums2 + 1];
        for (int i = 0; i < nums2.length; i++) {
            mapNums2[nums2[i]] = i;
        }

        for (int i = 0; i < nums1.length; i++) {
            int index = mapNums2[nums1[i]];
            while (index < nums2.length) {
                if (nums1[i] < nums2[index]) {
                    outputArray[i] = nums2[index];
                    break;
                } else {
                    outputArray[i] = -1;
                }
                index++;
            }
        }
        return outputArray;
    }
}
