/**
 * Created by YLT on 2017/7/11.
 */
public class T167 {
    /*原数组已经排好序
    * 返回两个下标，数组中的这两个值的和等于给定的整数
    * 二分查找法：缺点是要求待查表为有序表，且插入删除困难
    * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，则查找成功;否则利用中间位置记录将表分成前、后两个子表，
    * 如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功。
    * */
    public static void main(String[] args) {
        T167 t167 = new T167();
        int[] a = {2, 7, 11, 15};
        int[] end = t167.twoSum(a, 9);
        System.out.println(end[0] + ";" + end[1]);
    }

    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {

        }
        return new int[]{-1, -1};
    }

}
