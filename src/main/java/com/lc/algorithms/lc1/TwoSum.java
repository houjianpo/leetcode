package com.lc.algorithms.lc1;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 1. 两数之和
 *
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 * @author: 松针
 * @create: 2020-03-23 18:06
 **/
public class TwoSum {

    public static void main(String[] args) {
        // 测试数组
        int[] nums = new int[]{2, 7, 11, 15};
        // 目标值
        int target = 9;
        // 求值
        int[] result = twoSum(nums, target);
        // 打印结果
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }
    }

    /**
     * 才用map方式
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // 数组为空则直接返回
        if (null == nums) {
            return new int[]{};
        }
        // 方式一
        // for (int i = 0; i < nums.length -1; i++) {
        //     for (int k = i + 1; k < nums.length; k ++) {
        //         if (nums[i] + nums[k] == target) {
        //             return new int[]{i,k};
        //         }
        //     }
        // }
        // return new int[]{};
        // 方式二
        // 定义一个map，用来匹配是否已经存在匹配的对象了
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                // 找到与arr[i]匹配的数据，直接返回数据下标
                return new int[]{map.get(target - nums[i]), i};
            } else {
                // 找不到，则直接将当前元素加入到map中
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
