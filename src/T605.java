/**
 * Created by YLT on 2017/8/31.
 */
public class T605 {
    public static void main(String[] args) {
        T605 t605 = new T605();
        System.out.println(t605.canPlaceFlowers(new int [] {1,0,0,0,0,1},2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
/*
        for(int i = 1; i < flowerbed.length;i ++){

        }*/

        boolean flag = true;
        for(int i = 0 ;i <flowerbed.length - 1; i ++){
            if(flowerbed[i] == 1){
                flag = false;
            }else{
                if(flag == false){
                    flag = true;
                }else if (flowerbed[i] == 0 && flowerbed[i + 1] == 0){
                    flag = false;
                    n --;
                }
            }
        }

        if(flag == true && flowerbed[flowerbed.length - 1] == 0){
            n --;
        }
        if(n <= 0){
            return true;
        }else {
            return false;
        }
    }
}
