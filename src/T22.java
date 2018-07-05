import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/6/26.
 */
public class T22 {
    List<String > result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        huisu(n,n,"");
        return result;
    }

    public void huisu(int left, int right, String nowPath){
        if(left == 0 && right == 0){
            result.add(nowPath);
        }

        if (left > right){
            return;
        }

        if (left == 0){
            huisu(left,right - 1, nowPath + ')');
        }

        if (left != 0 && right != 0){
            huisu(left-1,right,nowPath+'(');
            huisu(left,right - 1,nowPath + ')');
        }
    }
}
