import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2018/8/2.
 */
public class T78 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        huisu(nums,length,0,new ArrayList<>());
        return result;
    }
    public void huisu(int[] nums,int length,  int index, List<Integer> nowPath){
        if (index == length){
            result.add(new ArrayList<Integer>(nowPath));
            return;
        }
        huisu(nums,length,index + 1,nowPath);
        nowPath.add(nums[index]);
        huisu(nums,length,index + 1, nowPath);
        nowPath.remove(nowPath.size() - 1);
    }
}
