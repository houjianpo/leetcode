package com.lc.algorithms.lc1189;

import java.util.Arrays;

/**
 * @description: 1189. "气球"的最大数量
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 * @author: 松针
 * @create: 2022-02-28 18:47
 **/
public class MaxNumberOfBalloon {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text) == 2);
    }

    public static int maxNumberOfBalloons(String text) {
        // 定义一个数组，用来记录传入的text中包含多少个 balloon 字母,去重后为 b a l o n
        int[] array = new int[5];

        // 遍历传入的text，获取每个字母出现的次数
        for (char s : text.toCharArray()) {
            if (s == 'b') {
                array[0]++;
            }
            if (s == 'a') {
                array[1]++;
            }
            if (s == 'l') {
                array[2]++;
            }
            if (s == 'o') {
                array[3]++;
            }
            if (s == 'n') {
                array[4]++;
            }
        }

        // 修正，因为balloon中l和o都出现两次，则 array[2]/2  array[3]/2
        array[2] /= 2;
        array[3] /= 2;

        return Arrays.stream(array).min().getAsInt();
    }
}
