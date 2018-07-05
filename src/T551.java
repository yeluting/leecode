/**
 * Created by YLT on 2017/7/11.
 */
public class T551 {
    public static void main(String[] args) {
        T167 t167 = new T167();
        int []a = {2,7,11,15};
        int []end = t167.twoSum(a,9);
        System.out.println(end[0]+";"+end[1]);
    }
    public boolean checkRecord1(String s) {
        if(s.contains("LLL")||s.indexOf("A")!=s.lastIndexOf("A")){
            return false;
        }
        return true;
    }
    public boolean checkRecord(String s) {
        int countL = 0;
        int countA = 0;
        char last = 'a';
        for(int i = 0;i < s.length();i++){
            char ch =s.charAt(i);
            if(s.charAt(i)=='A'){
                countA++;
                if(countA == 2){
                    return false;
                }
            }else if(s.charAt(i)=='L'){
                if(last == 'L'){
                    countL++;
                }else{
                    countL=1;
                }
                if(countL == 3){
                    return false;
                }
            }
            last = ch;
        }
        return true;
    }
}
