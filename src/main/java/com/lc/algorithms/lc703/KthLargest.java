package com.lc.algorithms.lc703;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: 松针
 * @create: 2020-04-23 10:15
 **/
public class KthLargest {

    /**
     * 优先级队列
     */
    private PriorityQueue<Integer> priorityQueue;

    /**
     * 第k大的元素
     */
    private Integer k;

    /**
     * 才用java中的PriorityQueue来，默认就是小顶堆，所以初始化队列大小为k就行了
     *
     * @param k    第k大的值
     * @param nums 流元素数组
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        // 将数组元素，依次入队
        for (int num : nums) {
            this.add(num);
        }
    }

    /**
     * 添加流元素到优先级队列中
     *
     * @param val 流元素
     * @return 当前第k大的值（队列头部的元素）
     */
    public int add(int val) {
        // 若是队列中元素个数小于k，则直接入队
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
        } else {
            // 若是队列中已经存在了k个元素，则将新值与队头元素比较，若是大于队头元素，则队头出队，新值入队
            if (priorityQueue.peek() < val) {
                // 队头出队
                priorityQueue.poll();
                // 新值入队
                priorityQueue.add(val);
            }
        }
        // 返回队头元素，这就是要的第k大的值
        return priorityQueue.peek();
    }
}
