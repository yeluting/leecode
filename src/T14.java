/**
<<<<<<< HEAD
 * Created by YLT on 2018/8/1.
 */
public class T14 {
    //垂直做法
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if (size == 0){
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        int length = strs[0].length();
        for (int i = 0; i < length; i ++){
            for (int j = 1; j < size; j ++){
                if (strs[j].length() <=i||strs[j].charAt(i) != (strs[0].charAt(i))){
                    return String.valueOf(buffer);
                }
                if (j == size - 1){
                    buffer.append(strs[0].charAt(i));
                }
            }
        }
        return String.valueOf(buffer);
    }

    //水平做法
    public String longestCommonPrefix1(String[] strs) {
        int size = strs.length;
        if (size == 0){
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < size; i++){
            while (strs[i].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
            }
            if (pre.equals("")){
                return "";
            }
        }
        return pre;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs ==null || strs.length==0){
            return "";
        }
        return getPrefix(strs,0,strs.length-1);
    }
    public String getPrefix(String[] strs, int begin, int end){
        if (begin == end){
            return strs[begin];
        }
        int mid = (begin + end)/2;
        String left = getPrefix(strs,begin,mid);
        String right = getPrefix(strs,mid+1,end);
        return getTwoCommon(left,right);
    }
    public String getTwoCommon(String str1, String str2){
        int min = Math.min(str1.length(),str2.length());
        for (int i = 0; i < min; i++){
            if (str1.charAt(i) != str2.charAt(i)){
                return str1.substring(0,i);
            }
        }
        return str1.substring(0,min);
    }

=======
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
>>>>>>> 1aafdc6cace775e962e917a773394fa5c5c714a1
}
