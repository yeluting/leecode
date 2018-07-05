import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2018/6/27.
 */
public class T49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> map = new HashMap<>();
        int length = strs.length;

        for (int i = 0; i < length; i ++){
            char [] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
