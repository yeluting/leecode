/**
 * Created by YLT on 2017/8/24.
 */
public class T661 {
    public static void main(String[] args) {
        T661 t661 = new T661();
        int[][] M = new int[][]{new int[]{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        t661.imageSmoother(M);

    }

    public int[][] imageSmoother(int[][] M) {
        int height = M.length;
        int len = M[0].length;
        int[][] result = new int[height][len];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                int count = 0;
                for (int row : new int[]{-1, 0, 1}
                        ) {
                    for (int col : new int[]{-1, 0, 1}) {
                        int x = i + row;
                        int y = j + col;
                        if (x >= 0 && x < height && y >= 0 && y < len) {
                            sum += M[i + row][j + col];
                            count++;
                        }
                    }
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    public boolean isValid(int x, int y, int height, int len) {
        return x >= 0 && x < height && y >= 0 && y < len;
    }

}
