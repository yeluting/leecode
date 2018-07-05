/**
 * Created by YLT on 2017/7/11.
 */
public class T557 {
    public String reverseWords1(String s) {
        StringBuffer w = new StringBuffer();
        String [] strs = s.split(" ");
        for (String str:strs
             ) {
            for (int j = str.length() - 1;j >= 0; j --){
                w.append(str.charAt(j));
            }
            w.append(' ');
        }
        w.deleteCharAt(w.length()-1);
        return w.toString();
    }

    public String reverseWords(String s) {
        int begin = 0,end;
        char[] ches = s.toCharArray();
        while((end = s.indexOf(' ',begin))!= -1){
            reverse(ches,begin,end-1);
            begin = end + 1;
        }
        reverse(ches,begin,ches.length-1);
        return new String(ches);
    }
    public void reverse(char[] arr,int start,int end){
        while(start <= end){
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start ++;
            end --;
        }
    }
}
