import java.util.ArrayList;

/**
 * Created by YLT on 2017/9/7.
 */
public class T566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int colomn = nums[0].length;
        if(c*r!=row*colomn){
            return nums;
        }
        int [][] results = new int[r][c];
        int k = 0,l = 0;
        for(int i = 0;i < row;i ++){
            for (int j = 0;j < colomn;j++){
                if(l == c ){
                    k++;
                    l = 0;
                }
                results[k][l++] = nums[i][j];
            }
        }
        return results;
    }
}
