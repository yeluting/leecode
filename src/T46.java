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

    public List<List<Integer>> permute1(int[] nums) {
        int length = nums.length;
        boolean [] flag = new boolean[length];
        huisu1(nums,new ArrayList<>(),length,flag);
        return result;
    }
    public void huisu1(int[] nums, ArrayList<Integer> nowPath, int length,boolean[] flag){
        if (length == nowPath.size()){
            result.add(new ArrayList<Integer>(nowPath));
            return;
        }
        for (int i = 0; i < length; i ++){
            if (flag[i] == true){
                continue;
            }
            flag[i] = true;
            nowPath.add(nums[i]);
            huisu1(nums,nowPath,length,flag);
            nowPath.remove(nums[i]);
            flag[i] = false;
        }
    }

}
