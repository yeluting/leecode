/**
 * Created by YLT on 2017/9/7.
 */
public class T405 {
    public static void main(String[] args) {
        T405 t167 = new T405();
        t167.toHex(26);
    }

    /*public String toHex(int num) {
        boolean flag = false;
        if (num == 0) {
            return "0";
        }
        String result = "";
        for (int i = 7; i >= 0; i--) {
            int middle = (num >>> (4 * i)) & 15;
            if (middle < 10 && middle > 0) {
                result = result.concat(String.valueOf(middle));
                flag = true;
            } else if (middle == 0 && flag == true) {
                result = result.concat(String.valueOf(middle));
            } else if (middle >= 10){
                flag = true;
                switch (middle) {
                    case 10:
                        result = result.concat("a");
                        break;
                    case 11:
                        result = result.concat("b");
                        break;
                    case 12:
                        result = result.concat("c");
                        break;
                    case 13:
                        result = result.concat("d");
                        break;
                    case 14:
                        result = result.concat("e");
                        break;
                    case 15:
                        result = result.concat("f");
                        break;
                }
            }
        }
        System.out.println(result);
        return result;
    }*/

    public String toHex(int num) {
        char [] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0){
            return "0";
        }
        String result ="";
        while (num != 0){
            result = map[num & 15] + result;
            num = num >>>4;
        }
        return result;
    }

}
