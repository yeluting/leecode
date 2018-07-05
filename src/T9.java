/**
 * Created by YLT on 2017/11/6.
 */
public class T9 {
    /*public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int mid = x;
        int revert = 0;
        while(x > 0){
           revert = revert * 10 + x % 10;
            x = x / 10;
        }
        if(mid == revert)
            return true;
        else return false;
    }*/

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revert = 0;
        while(x > revert){
            revert = revert * 10 + x % 10;
            x = x / 10;
        }
        return x == revert || x == revert/10;
    }
}
