/**
 * Created by YLT on 2017/10/27.
 *//*

public class T680 {
    */
/*boolean flag = true;
    public boolean validPalindrome(String s) {
        if(s.length() == 1) return true;

        int i = 0, j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i ++;
                j --;
            }else{
                if(flag == true){
                    flag = false;
                    System.out.println(s.substring(i,j));
                    return validPalindrome(s.substring(i,j)) || validPalindrome(s.substring(i + 1,j + 1));
                }else
                {
                    return false;
                }
            }
        }
        return true;
    }*//*

    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int st = 0;
        int en = c.length - 1;
        while(st<=en){
            if(c[st] == c[en]){
                st++;
                en--;
            }else{
                return (isPalindrome(c, st, en-1) || isPalindrome(c, st+1, en));
            }
        }
        return true;
    }


    public boolean isPalindrome(char[] arr, int st_indx, int en_indx){
        while(st_indx <= en_indx){
            if(arr[st_indx] == arr[en_indx]){
                st_indx++;
                en_indx--;
            } else{
                return false;
            }
        }
        return true;
    }
}

}
*/
