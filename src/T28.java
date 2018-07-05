/**
 * Created by YLT on 2017/7/14.
 */
public class T28 {
    public int strStr1(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }
        int index = haystack.indexOf(needle);
        return index;
    }
    public int strStr(String haystack, String needle) {
        int length2 = needle.length();
        int length1 = haystack.length();
        if (haystack == null || length1 < length2) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }
        for(int i = 0; i <= length1 - length2;i ++){
            if(haystack.substring(i,i + length2).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
