/**
 * Created by YLT on 2017/7/11.
 */

/*
* 动态规划问题：组合优化问题。对应的目标函数和约束条件将求解过程变成一个多步判断的过程
* 算法细心得划分子问题的边界，从小的问题开始，逐层向上求解，通过子问题之间的依赖关系，有效利用前面已经得到的成果，减少重复工作
* */
public class T198 {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int [] result = new int[nums.length + 1];
        result[1] = nums[0];
        result[2] = Math.max(nums[0],nums[1]);
        for (int i = 3; i <= nums.length;i ++){
            result[i] = Math.max(result[i-1],result[i-2] + nums[i-1]);
        }
        return result[nums.length];
    }
}
