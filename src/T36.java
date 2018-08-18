import java.util.HashSet;

/**
 * Created by YLT on 2018/8/1.
 */
public class T36 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String > set = new HashSet<>();
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j ++){
                char number = board[i][j];
                if (number!='.'){
                    if (!set.add(number + "in row" + i)
                            || !set.add(number + "in column" + j)
                            || !set.add(number + "in" + i/3 + "-" + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
