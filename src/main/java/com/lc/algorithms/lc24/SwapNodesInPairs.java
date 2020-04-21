package com.lc.algorithms.lc24;

import com.lc.algorithms.base.ListNode;

/**
 * @description: 24.两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * @author: 松针
 * @create: 2020-04-21 19:18
 **/
public class SwapNodesInPairs {

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
        ListNode reverse = swapPairs(head);

        // 遍历打印
        while (null != reverse) {
            System.out.print(reverse.val + " ");
            // 后移一位
            reverse = reverse.next;
        }
    }

    /**
     *         node1 node2 next
     * xHead -> 1  -> 2  -> 3  -> 4  -> 5
     *         node2 node1 next
     * xHead -> 2  -> 1  -> 3  -> 4  -> 5
     */
    public static ListNode swapPairs(ListNode head) {
        // 定义虚拟头结点
        ListNode xHead = new ListNode(0);
        // 将虚拟头结点指向head
        xHead.next = head;
        // 需要交换的当前节点
        ListNode current = xHead;

        // 交换，如题，当current.next 和 current.next.next 都不为空，才进行交换
        while (null != current.next && null != current.next.next) {
            // 定义指向1的node1变量
            ListNode node1 = current.next;
            // 定义指向2的node2变量
            ListNode node2 = node1.next;
            // 定义指向3的next变量
            ListNode next = node2.next;

            // 交换 node2.next指向前一个node1(也就是2->1) (原node2.next指向的是3的地址，断开2->3)
            node2.next = node1;
            // 交换 node1.next指向next的地址(也就是1->3)
            node1.next = next;
            // 置位current.next指向到交换前的1的next位置，现在就是2 (xHead->2) 链接后的链路为(xHead->2->1->3->4->5)
            current.next = node2;
            // 将current移动到交换后1的位置node1,也就是3的头位置,下次从3开始交换
            current = node1;
        }
        // 全部交换完毕，返回交换后的头结点
        return xHead.next;
    }
}
