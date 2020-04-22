package com.lc.algorithms.lc232;

import java.util.Stack;

/**
 * @description: 自定义队列, 用Stack来实现
 * @author: 松针
 * @create: 2020-04-22 13:34
 **/
public class MyQueue {

    /**
     * 入队(栈)
     */
    private Stack<Integer> input = new Stack<>();

    /**
     * 出队(栈)
     */
    private Stack<Integer> output = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 压入入队(栈)
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (output.isEmpty()) {
            // 若是出队堆栈为空，则将入队堆栈中的数据导入到出栈队列中
            changeInput2Ouuput();
        }
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
     */
    public int peek() {
        if (output.isEmpty()) {
            // 若是出队堆栈为空，则将入队堆栈中的数据导入到出栈队列中
            changeInput2Ouuput();
        }
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}
