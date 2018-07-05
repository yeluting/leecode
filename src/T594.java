import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by YLT on 2017/9/1.
 */
public class T594 {
    public int findLHS(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i ++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            if(map.containsKey(key + 1)){
                int maxtemp =(int)entry.getValue() + map.get(key + 1);
                if( maxtemp > max) {
                    max = maxtemp;
                }
            }
        }
        return max;
    }
}
