package com.lc.algorithms.lc242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * @author: 松针
 * @create: 2020-04-24 13:21
 **/
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "abcdefg";
        String t = "abcdefg";
//        String t = "fdsafds";

        System.out.println(isAnagram2(s, t));
    }

    /**
     * 方案一：把字符串中的按照字典序排序一下，然后按位比较，到结尾，都一样，就返回true，否则返回false
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        // 时间复杂度 O(n*logn)
        // 长度不相等，直接返回
        if (s.length() != t.length()) {
            return false;
        }
        // 转为字符数组
        char[] sChar = s.toCharArray();
        char[] tCahr = t.toCharArray();
        // 排序
        Arrays.sort(sChar);
        Arrays.sort(tCahr);
        // 比较
        return Arrays.equals(sChar, tCahr);
    }

    /**
     * 方案二：用map来对字符串中的每一个字符串记数{"latter":count}
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        // 本例采用方案二，时间复杂度是 O(n)
        Map<Character, Integer> sMap = new HashMap<>();
        // 对源字符串中所有字符存入map中，并记录其出现的次数
        for (char c : s.toCharArray()) {
            sMap.put(c, null == sMap.get(c) ? 0 : sMap.get(c) + 1);
        }

        Map<Character, Integer> tMap = new HashMap<>();
        // 对源字符串中所有字符存入map中，并记录其出现的次数
        for (char c : t.toCharArray()) {
            tMap.put(c, null == tMap.get(c) ? 0 : tMap.get(c) + 1);
        }
        return sMap.equals(tMap);
    }
}
