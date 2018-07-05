import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by YLT on 2017/9/1.
 */
public class T389 {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i ++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                map.remove(c);
            }else {
            map.put(c,map.get(c)-1);}
        }
        Iterator iterator = map.keySet().iterator();
        return (char) iterator.next();
    }
    //按位异或
    public char findTheDifference1(String s, String t) {
        int sum = 0;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        for(int i =0; i < a.length; i++ ) sum ^= (a[i]^b[i]);
        sum = sum ^ b[b.length-1];
        return (char)sum;
    }
}
