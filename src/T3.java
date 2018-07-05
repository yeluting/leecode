import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Callable;

/**
 * Created by YLT on 2017/11/6.
 */
public class T3 {

    public int lengthOfLongestSubstring3(String s) {
        int flags[] = new int[128];
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length;i ++){
            int mid = i - flags[s.charAt(i)] + 1;
            result = Math.max(result,mid);
            flags[s.charAt(i)] = i + 1;
        }
        return result;
    }


 public int lengthOfLongestSubstring1(String s) {
     HashMap<Character,Integer> map = new HashMap<>();
     int length = s.length();
     int result = 0;
     for (int i = 0,j = 0; i < length;i ++){
         if(map.containsKey(s.charAt(i))){
             j = Math.max(j,map.get(s.charAt(i)));
         }
         result = Math.max(result,i - j + 1);
         map.put(s.charAt(i),i + 1);
     }
     return result;
 }

    public int lengthOfLongestSubstring2(String s) {
        HashSet set = new HashSet();
        int i = 0, j = 0,ans = 0;
        int length = s.length();
        while (i < length && j < length){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            }else {
                set.remove(s.charAt(i ++));
            }
        }
        return ans;
    }
}
