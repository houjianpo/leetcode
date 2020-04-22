package com.lc.algorithms.lc232;

import java.util.Stack;

/**
 * @description: 自定义队列, 用Stack来实现
 * @author: 松针
 * @create: 2020-04-22 13:34
 **/
public class MyQueue {

    /**
     * 声明入队(栈)
     */
    private Stack<Integer> input;

    /**
     * 声明出队(栈)
     */
    private Stack<Integer> output;

    /**
     * Initialize your data structure here.
     * 初始化两个堆栈
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     * 入队(压入input栈)
     */
    public void push(int x) {
        // 入队(压入input栈)
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     * 出队，若是output为空，则将input中数据导入到output中，然后在从output中出栈(队)
     */
    public int pop() {
        if (output.isEmpty()) {
            // 若是output为空，则将input中数据导入到output中
            changeInput2Ouuput();
        }
        // 从output中出栈(队)
        return output.pop();
    }

    /**
     * 将入栈队列中数据导入到出栈队列中
     */
    private void changeInput2Ouuput() {
        if (!input.isEmpty()) {
            // 如果入栈队列中不为空，才进行导数据
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    /**
     * Get the front element.
     * 查看队头元素，若是output为空，则将input中数据导入到output中，然后在从output中查看栈顶(队头)元素
     */
    public int peek() {
        if (output.isEmpty()) {
            // 若是output为空，则将input中数据导入到output中
            changeInput2Ouuput();
        }
        // 从output中查看栈顶(队头)元素
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     * 判断队列是否为空，只有input和output同时为空，才为空
     */
    public boolean empty() {
        // 判断队列是否为空，只有input和output同时为空，才为空
        return output.isEmpty() && input.isEmpty();
    }
}
