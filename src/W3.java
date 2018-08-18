import java.util.Scanner;

/**
 * Created by YLT on 2018/8/10.
 */
public class W3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
        int length = str.length();
        int count = 1;
        char pre = str.charAt(0);
        for (int i = 1; i < length; i ++){
            if (str.charAt(i) != pre){
                pre = str.charAt(i);
                count++;
            }
        }
        System.out.println(df.format(length/(double)count));
    }
}
