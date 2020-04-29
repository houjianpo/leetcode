package com.lc.algorithms.lc50;

/**
 * @description: 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 松针
 * @create: 2020-04-29 13:24
 **/
public class PowxN {

    public static void main(String[] args) {
        System.out.println(myPow(34.00515, -3));
    }

    /**
     * 采用分治的算法，就类似我们之前算过的从1加到100的和那样，把每次的问题都减半处理
     * 递归方案
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        // 递归的终止条件
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        // 处理一半的x的乘积
        double half = myPow(x, n / 2);
        // 若是n为基数，还需要在乘以一次x
        return n % 2 == 1 ? half * half * x : half * half;
    }
}
