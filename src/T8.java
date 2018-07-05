/**
 * Created by YLT on 2017/11/6.
 */
public class T8 {
    /*public int myAtoi(String str) {
        if (str == null || str.equals("")) return 0;
        if (str.length() == 1) {
            if (Character.isDigit(str.charAt(0))) {
                return Integer.parseInt(str);
            } else {
                return 0;
            }
        }
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        }
        if (!str.substring(1).matches("[0-9]+")) {
            return 0;
        }
        long longNum = Long.parseLong(str);
        if(longNum > Integer.MAX_VALUE || longNum < Integer.MIN_VALUE){
            return 0;
        }
        return (int) longNum;
    }*/

    public int myAtoi(String str) {
        if (str == null || str.equals("")) return 0;
        if (str.length() == 1) {
            if (Character.isDigit(str.charAt(0))) {
                return Integer.parseInt(str);
            } else {
                return 0;
            }
        }
        long num = 0;
        int i = 0;
        boolean flag = true;
        if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') {
            return 0;
        };
        if(str.charAt(0) == '-'){
            flag = false;i = 1;
        }
        if(str.charAt(0) == '+'){
            i = 1;
        }
        for(;i < str.length(); i ++){
            if(!Character.isDigit(str.charAt(i))){
                return 0;
            }
            num = num * 10 + str.charAt(i) - 48;
            if(num > Integer.MAX_VALUE || num <Integer.MIN_VALUE){
                return 0;
            }
        }
        if(flag){
            return (int) num;
        }else
            return (int) -num;

    }
}
