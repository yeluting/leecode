/**
 * Created by YLT on 2017/11/16.
 */
public class T74 {
   /* public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length== 0) return false;
        int h = matrix.length;
        int l = matrix[0].length;
        int level=0;
        if(matrix[0][0] > target || matrix[h - 1][l - 1] < target) return false;
        for(int i = 0; i < h;i++){
            if(matrix[i][0] <= target && matrix[i][l-1] >= target){
                level = i;
                break;
            }
        }
        return find(matrix[level],target,0,l-1);
    }

    public boolean find(int []numbers,int target,int begin,int end){
        if(begin > end) return false;
        int mid = (begin + end)/2;
        if(numbers[mid] == target) return true;
        else if(numbers[mid] < target) return find(numbers,target,mid + 1,end);
        else return find(numbers,target,begin,mid - 1);
    }
   public boolean find1(int []numbers,int target,int begin,int end){
       while (begin <= end){
           int mid = (begin+end)/2;
           if(numbers[mid] == target){
               return true;
           }else if(numbers[mid] > target){
               end = mid - 1;
           }else {
               begin = mid + 1;
           }
       }
       return false;
   }*/

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = matrix.length - 1,j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
