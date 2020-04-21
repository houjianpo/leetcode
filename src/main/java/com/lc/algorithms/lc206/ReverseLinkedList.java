package com.lc.algorithms.lc206;

import com.lc.algorithms.base.ListNode;

/**
 * @description: 206.反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author: 松针
 * @create: 2020-04-21 13:59
 **/
public class ReverseLinkedList {

    /**
     * 初始化链表
     *
     * @return
     */
    public static ListNode init() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ln1.next = ln2;
        ListNode ln3 = new ListNode(3);
        ln2.next = ln3;
        ListNode ln4 = new ListNode(4);
        ln3.next = ln4;
        ListNode ln5 = new ListNode(5);
        ln4.next = ln5;
        return ln1;
    }

    public static void main(String[] args) {
        ListNode head = init();
        ListNode reverse = reverseList(head);

        // 遍历打印
        while (null != reverse) {
            System.out.print(reverse.val + " ");
            // 后移一位
            reverse = reverse.next;
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 前继结点
        ListNode prev = null;
        // 当前节点为head
        ListNode cur = head;
        // 遍历节点，直到为null
        while (null != cur) {
            // 定义临时变量，保存cur的下一个节点，防止cur改变后，丢失后续节点
            ListNode tmp = cur.next;
            // 当前节点的后继指针指向prev，之后cur则被断开成为独立的ListNode节点
            cur.next = prev;
            // 前继节点保存当前记录的值
            prev = cur;
            // 当前节点后移一位
            cur = tmp;
        }
        return prev;
    }
}
