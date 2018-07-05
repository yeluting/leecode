/**
 * Created by YLT on 2017/10/27.
 */
public class T125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0,j = s.length()-1;
        while (i < j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i ++;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j --;
            }
            if(i < j){
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }else{
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
        s = s.toLowerCase();
        int i = 0,j = s.length()-1;
        while (i < j){
            if (!Character.isLetterOrDigit(s.charAt(i))){
                i ++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))){
                j --;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }

}
