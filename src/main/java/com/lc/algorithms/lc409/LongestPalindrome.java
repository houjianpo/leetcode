package com.lc.algorithms.lc409;

/**
 * @description: 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 * <p>
 * 示例 1:
 * 输入:s = "abdccaccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 示例 2:
 * 输入:s = "a"
 * 输入:1
 * <p>
 * 示例 3:
 * 输入:s = "bb"
 * 输入: 2
 * <p>
 * 提示:
 * 1 <= s.length <= 2000
 * s只能由小写和/或大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </p>
 * @author: 松针
 * @create: 2022-03-04 10:34
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abdccaccdd";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 最长回文长度
     *
     * @param s 需要判断最长回文长度的字符串
     * @return 最长回文长度
     */
    public static int longestPalindrome(String s) {
        // 要返回的回文字符串长度
        Integer len = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (isHuiWen(tmp) && tmp.length() > len) {
                    len = tmp.length();
                }
            }
        }

        return len;
    }

    /**
     * 判断字符串是否是回文
     *
     * @param s 需要判断是否是回文的字符串
     * @return 是true/不是false
     */
    public static boolean isHuiWen(String s) {
        // 1个字符不是回文
        if (s.length() == 1) {
            return false;
        }

        boolean flag = true;
        char[] ch = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (ch[i] != ch[j]) {
                flag = false;
            }
        }
        return flag;
    }
}
