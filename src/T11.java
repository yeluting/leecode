/**
 * Created by YLT on 2017/11/7.
 */
public class T11 {
    public int maxArea(int[] height) {
        int max = 0;
        int begin = 0,end = height.length - 1;

        while (begin < end){
            max = Math.max(max,(end - begin) * Math.min(height[begin],height[end]));
            if(height[begin] < height[end]){
                begin++;
            }else {
                end --;
            }
        }
        return max;
    }
}
