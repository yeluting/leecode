import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLT on 2017/11/15.
 */
public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> numbers = new ArrayList<>();
        if(matrix.length == 0) return numbers;
        int h = matrix.length;
        int l = matrix[0].length;
        boolean [][]visited = new boolean[h][l];
        int []ud = new int[]{0,1,0,-1};
        int []rl = new int[]{1,0,-1,0};
        int i = 0, j = 0, di = 0;
        System.out.println(h*l);
        for(int n = 0;n < h * l;n++){
            System.out.println(matrix[i][j]);
            numbers.add(matrix[i][j]);
            visited[i][j] = true;
            int i1 = i + ud[di];
            int j1 = j + rl[di];
            if(i1 >=0 && i1 < h && j1>=0 && j1 <l && !visited[i1][j1]){
                i = i1;j=j1;
            }else{
                di = (di + 1)%4;
                i = i + ud[di];
                j = j + rl[di];
            }
        }
        return numbers;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> numbers = new ArrayList<>();
        if(matrix.length == 0) return numbers;
        int r1 = 0,c1 = 0,r2 = matrix.length - 1,c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2){
            for(int c = c1;c <= c2; c++){
                numbers.add(matrix[r1][c]);
            }
            for(int r = r1 + 1;r <= r2;r ++){
                numbers.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
            for (int c = c2 - 1; c >= c1; c --){
                numbers.add(matrix[r2][c]);
            }
            for (int r = r2 - 1; r > r1;r--){
                numbers.add(matrix[r][c1]);
            }}
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return numbers;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> numbers = new ArrayList<>();
        if(matrix.length == 0) return numbers;
        int r1 = 0, c1 = 0, r2 = matrix.length-1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2){
            for (int c = c1; c <= c2; c++){
                numbers.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r < r2; r ++){
                numbers.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2){
                for (int c = c2; c >= c1; c--){
                    numbers.add(matrix[r2][c]);
                }
                for (int r = r2 - 1; r > r1; r --){
                    numbers.add(matrix[r][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return numbers;
    }
}
