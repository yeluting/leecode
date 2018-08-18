import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2018/8/3.
 */
public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int i = 1; i < numRows; i ++){
            ArrayList temp = new ArrayList();
            temp.add(1);
            List<Integer> pre = triangle.get(i - 1);
            for (int j = 1; j < i; j ++){
                temp.add(pre.get(j) + pre.get(j-1));
            }
            temp.add(1);
            triangle.add(temp);
        }
        return triangle;
    }
}
