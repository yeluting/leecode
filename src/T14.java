/**
 * Created by apple on 2018/7/11.
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        int count = Integer.MAX_VALUE;
        for (String str:strs){
            if (count > str.length()){
                count = str.length();
            }
        }
        int begin = 0, end = count - 1;
        while (begin <= end){
            int mid = (begin + end)/2;
            
        }
    }
}
