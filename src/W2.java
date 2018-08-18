import java.util.Scanner;

/**
 * Created by YLT on 2018/8/10.
 */
public class W2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int result = num;
        int xiangfan = 0;
        while (num!=0){
            xiangfan = xiangfan*10 + num%10;
            num = num/10;
        }
        System.out.println(result+xiangfan);
    }
}
