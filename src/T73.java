import java.util.HashSet;

/**
 * Created by YLT on 2018/8/2.
 */
public class T73 {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int col = 0;

        for (int i = 0; i < height; i ++){
            if (matrix[i][0] == 0) col = 1;
            for (int j = 1; j < width; j ++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = height - 1; i >=0; i --){
            for (int j = width - 1; j >=1; j --){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col == 1){
                matrix[i][0] = 0;
            }
        }
    }
}
