/**
 * Created by YLT on 2017/11/16.
 */
public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n - 1;
        while (total >= 0){
            if(m == 0){nums1[total --] = nums2[--n];}
            else if(n == 0) break;
            else {
                nums1[total--] = nums1[m - 1] > nums2[n - 1]?  nums1[--m]:nums2[--n];
            }
        }
    }
}
