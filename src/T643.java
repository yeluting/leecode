/**
 * Created by YLT on 2017/8/30.
 */
public class T643 {
    public double findMaxAverage1(int[] nums, int k) {
        double average = Double.NEGATIVE_INFINITY;
        for(int i = 0; i <= nums.length - k; i ++){
            double sum = 0.0;
            for(int j = 0 ;j < k;j ++){
                sum += nums[i+j];
            }
            double newAverage = sum/k;
            if(newAverage > average){
                average = newAverage;
            }
        }
        return average;
    }
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for(int i = 0; i < k;i ++){
            sum += nums[i];
        }
        double average = sum/k;
        for(int i = 1; i <= nums.length - k; i ++){
            sum = sum - nums[i - 1] + nums[i + k - 1];
            double newAverage = sum/k;
            if(newAverage > average){
                average = newAverage;
            }
        }
        return average;
    }
}
