import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class T46 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        huisu(nums,new ArrayList<>());
        return result;
    }

    public void huisu(int [] nums, ArrayList<Integer> nowPath){
        if (nowPath.size() == nums.length){
            result.add(new ArrayList<>(nowPath));
            return;
        }

        int length = nums.length;
        for (int i = 0;i < length; i ++){
            if (nowPath.contains(nums[i])){
                continue;
            }
            nowPath.add(nums[i]);
            huisu(nums,nowPath);
            nowPath.remove(nowPath.size() - 1);
        }
    }

}
