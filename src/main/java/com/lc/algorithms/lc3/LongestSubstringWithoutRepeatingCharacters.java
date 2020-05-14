package com.lc.algorithms.lc3;

/**
 * @description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * @author: 松针
 * @create: 2020-05-14 10:16
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 验证字符串合法性
        if (null == s || s.length() == 0) {
            return 0;
        }
        // 左游标
        int left = 0;
        // 右游标
        int right = 0;
        // 最大不重复字符串长度值
        int max = 0;
        // 字符串总长度
        int len = s.length();
        // 用boolean数组来判断出现过的字符是否重复了，长度128位:ASCII也是128位
        boolean[] used = new boolean[128];
        // 开始统计，右游标要小于字符串总长度，防止数组越界
        while (right < len) {
            // 右游标所在的字符在已经访问过的boolean数组中不存在
            if (used[s.charAt(right)] == false) {
                // 已经访问过了，就标记为true
                used[s.charAt(right)] = true;
                // 右侧游标继续右移一位
                right++;
            } else {
                max = Math.max(max, right - left);
                // 左游标要小于右游标，并且当前右游标上的值与左游标所在的值不一样，则左游标右移一位
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    // 恢复当前值为false
                    used[s.charAt(left)] = false;
                    // 左游标右移一位
                    left++;
                }
                // 若是左游标字符与右游标字符相同，那么这两个都各自右移一位
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}
