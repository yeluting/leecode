import java.util.List;

/**
 * Created by YLT on 2018/5/17.
 */
public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        for (int i = height - 2; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j ++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
