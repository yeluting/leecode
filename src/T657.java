/**
 * Created by YLT on 2017/8/31.
 */
public class T657 {
    public boolean judgeCircle(String moves) {
        int [] times = new  int[]{0,0,0,0};
        for (int i = 0; i < moves.length();i ++){
            char w = moves.charAt(i);
            if(w=='U'){
                times[0]++;
            }else if(w=='D'){
                times[1]++;
            }else if(w=='L'){
                times[2]++;
            }else if(w=='R'){
                times[3]++;
            }
        }
        if(times[0]==times[1]&&times[2]==times[3]){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        T657 t657 = new T657();
        t657.judgeCircle1("UD");
    }
    public boolean judgeCircle1(String moves) {
        int[] map=new int[256];
        for(char c: moves.toCharArray()){
            System.out.println(c);
            map[c]++;
        }
        if(map['L']==map['R'] && map['U']==map['D'])
            return true;
        else
            return false;
    }
}
