package com.lc.algorithms.lc415;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
 * <p>
 * 提示：
 * num1 和num2的长度都小于 5100
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddString {

    public static void main(String[] args) {
        String s1 = "1265433445246254133543146543543154353";
        String s2 = "53141355143565641343154135413543543514354135434324";
        String sum = addStrings(s1, s2);
        System.out.println(s1 + " + " + s2 + " = " + sum);
    }

    public static String addStrings(String num1, String num2) {
        int[] a1 = new int[1024];
        int l1 = change2Array(num1, a1);

        int[] a2 = new int[1024];
        int l2 = change2Array(num2, a2);

        // 最大长度
        int maxLength = l1 > l2 ? l1 : l2;
        // 数组长度短的后卫补0
//        if (l1 > l2) {
//            for (int i = l2; i < maxLength; i++) {
//                a2[i] = 0;
//            }
//        } else {
//            for (int i = l1; i < maxLength; i++) {
//                a1[i] = 0;
//            }
//        }
        // 定义数组长度+1，可能会有进位
        int[] result = new int[maxLength + 1];
        // 最大长度
        int resultLen = 0;
        // 进位
        int addOne = 0;
        for (int i = 0; i < maxLength; i++) {
            int b = addOne + a1[i] + a2[i];
            // 得到进位值
            addOne = b > 10 ? 1 : 0;
            // 得到个位值
            result[resultLen++] = b % 10;
        }
        // 如果最后进位值等于1，在加一位
        if (addOne == 1) {
            result[resultLen++] = 1;
        }
        String resultString = "";
        // 在反转回来
        for (int i = resultLen; i >= 0; i--) {
            // 数字首字符不能为0
            if (i == resultLen && result[resultLen] == 0) {
                continue;
            }
            resultString += result[i];
        }
        System.out.println(resultString);
        return resultString;
    }

    public static int change2Array(String str, int[] array) {
        // 得到字符串的长度
        int len = str.length();
        char[] c = str.toCharArray();
        // 声明变量，
        int j = 0;
        // 声明变量，用来索引字符串str
        for (int i = len - 1; i >= 0; i--) {
            array[j++] = Integer.parseInt(String.valueOf(c[i]));
        }
        // 总的字符串长度
        return j;
    }
}
