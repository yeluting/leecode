import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by apple on 2018/6/26.
 */
public class T39 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        huisu(candidates,0,target,new ArrayList<Integer>(),0);
        return result;
    }

    public void huisu(int[] candidates,int start, int target, List<Integer> nowList, int nowSum){
        if (nowSum == target){
            result.add(new ArrayList(nowList));
            return;
        }

        int length = candidates.length;
        for (int i = start; i < length; i ++){
            if (nowSum + candidates[i] > target){
                continue;
            }else {
                nowList.add(candidates[i]);
                nowSum += candidates[i];
                huisu(candidates,i,target,nowList,nowSum);
                nowSum -=  nowList.get(nowList.size() - 1);
                nowList.remove(nowList.size() - 1);
            }
        }
    }
}
