/**
 * Created by apple on 2018/6/27.
 */
public class T48 {
    public void rotate(int[][] matrix) {
        int l = 0;//最左边一列
        int r = matrix.length - 1;//最右边一列
        int c = 0;//最上面一行
        int f = r;//最下面一行

        while (l < r){
            int step = r - l;
            for (int i = 0; i < step; i ++){
                int temp = matrix[c][l+i];
                matrix[c][l+i] = matrix[f - i][c];
                matrix[f - i][c] = matrix[f][r-i];
                matrix[f][r-i]=matrix[c+i][r];
                matrix[c+i][r] = temp;
            }
            l++;
            r--;
            c++;
            f--;
        }
    }
}
