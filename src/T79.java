/**
 * Created by YLT on 2018/8/2.
 */
public class T79 {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean [][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j ++){
                if (find(board,rows,cols,i,j,word,0,word.length(),visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board,int rows, int cols, int r, int c, String word, int index, int length, boolean[][] visited){
        if (length == index){
            return true;
        }
        boolean flag = false;
        if (r < rows && r >=0 && c >=0 && c < cols && visited[r][c] == false && board[r][c] == word.charAt(index)){
            visited[r][c] = true;
             flag = find(board,rows,cols,r+1,c,word,index + 1, length,visited) ||
                    find(board,rows,cols,r-1,c,word,index + 1, length,visited) ||
                    find(board,rows,cols,r,c+1,word,index + 1, length,visited) ||
                    find(board,rows,cols,r,c-1,word,index + 1, length,visited);
            visited[r][c] = false;
        }

        return flag;
    }
}
