package com.lc.algorithms.lru;

/**
 * 双向链表中的节点
 */
public class Node {
    /**
     * 键
     */
    int key;

    /**
     * 值
     */
    int value;

    /**
     * 前驱结点
     */
    Node pre;

    /**
     * 后驱节点
     */
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        pre = null;
        next = null;
    }
}
