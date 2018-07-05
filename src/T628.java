import java.util.ArrayList;

/**
 * Created by YLT on 2017/8/30.
 */
public class T628 {
    public static void main(String[] args) {
        T628 t628 = new T628();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
    }
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }


    //错了的原因是没有考虑负数的状况，只求了topk
   /* public int maximumProduct(int[] nums) {
        ArrayList<Integer> numsToArray = new ArrayList<>();
        for (int i : nums
                ) {
            numsToArray.add(i);
        }
        ArrayList<Integer> end = findTopK(numsToArray, 3);
        return end.get(0) * end.get(1) * end.get(2);
    }*/

    public ArrayList<Integer> findTopK(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        if (nums.size() <= k) {
            return nums;
        }
        ArrayList<Integer>[] middle = partition(nums);
        result = findTopK(middle[0], k);
        result.addAll(findTopK(middle[1], k - middle[0].size()));
        System.out.println(result.toString());
        return result;
    }

    public ArrayList<Integer>[] partition(ArrayList<Integer> nums) {
        ArrayList<Integer>[] result = new ArrayList[2];
        ArrayList<Integer> middle1 = new ArrayList<>();
        ArrayList<Integer> middle2 = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int numsi = nums.get(i);
            boolean b = numsi > nums.get(0) ? middle1.add(numsi) : middle2.add(numsi);
        }
        boolean b = middle1.size() > middle2.size() ? middle2.add(nums.get(0)) : middle1.add(nums.get(0));
        result[0] = middle1;
        result[1] = middle2;
        return result;
    }

}
