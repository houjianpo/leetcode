package com.lc.algorithms.lc20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * @author: 松针
 * @create: 2020-04-22 10:06
 **/
public class ValidParentheses {
    /**
     * 示例1:true
     */
    static String str1 = "()";

    /**
     * 示例2:true
     */
    static String str2 = "()[]{}";

    /**
     * 示例3:false
     */
    static String str3 = "(]";

    /**
     * 示例4:false
     */
    static String str4 = "([)]";

    /**
     * 示例5:true
     */
    static String str5 = "{[]}";

    public static void main(String[] args) {
        System.out.println(isValid3(str5));
    }

    /**
     * 方法1：采用Stack方式来解
     */
    public static boolean isValid1(String s) {
        // 传入空串，直接返回true
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            // 如果插入字符是 右侧的任何一个，直接跟当前栈顶值进行比对，能匹配上，则直接取出栈顶
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // 如果当前栈不为空，并且栈顶元素是与传入的 ) 括号所匹配的 ( 则出栈
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    // 如果当前栈不为空，并且栈顶元素是与传入的 ) 括号所匹配的 ( 则出栈
                    stack.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    // 如果当前栈不为空，并且栈顶元素是与传入的 ) 括号所匹配的 ( 则出栈
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                // 不是右侧的括号，直接入栈
                stack.push(s.charAt(i));
            }
        }
        // 所有的括号都匹配上了，直接返回true
        if (stack.isEmpty()) {
            return true;
        }
        // 否则返回false
        return false;
    }

    /**
     * 方法2：采用Stack + Map方式来解
     */
    public static boolean isValid2(String s) {
        // 传入空串，直接返回true
        if (s.length() == 0) {
            return true;
        }
        // 定义临时堆栈
        Stack<Character> stack = new Stack<>();
        // 定义临时map，用来作为匹配，减少代码量
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            if (null == map.get(s.charAt(i))) {
                // 如果说传入的括号不是map中任何一个key，说明是左括号，直接压入栈
                stack.push(s.charAt(i));
            } else {
                // 传入的是右括号，则与当前栈顶元素比较
                if (stack.peek().equals(map.get(s.charAt(i)))) {
                    // 匹配上了，栈顶元素出栈
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    /**
     * 方法3：采用() {} [] 两两匹配，并且消除的方式来解
     */
    public static boolean isValid3(String s) {
        int len;
        // 若是替换后，两个长度值不相等，则跳出循环
        do {
            len = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        while (len != s.length());
        // 消除合法括号后，原字符串长度为0则为true，不为0则为false
        return s.length() == 0;
    }
}
