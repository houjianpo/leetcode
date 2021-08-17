package com.lc.algorithms.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map = new HashMap<>();

    /**
     * 队列大小
     */
    int size;

    /**
     * 头结点
     */
    Node head;

    /**
     * 尾结点
     */
    Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        head = null;
        tail = null;
    }

    /**
     * 删除节点
     *
     * @param node
     */
    void remove(Node node) {
        // 如果要删除的节点的前驱结点不为空，需要移动
        if (node.pre != null) {
            // 将要删除的元素的前面元素的next指针指向要删除元素的next对象上，这样就删除了node元素
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        // 要删除的节点的后续节点不为空
        if (node.next != null) {
            // 将要删除的元素的后续元素的pre指针指向要删除元素的pre指针
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    /**
     * 头结点插入
     *
     * @param node
     */
    void insertHead(Node node) {
        // 将node挂到head前面
        node.next = head;
        // node的前置节点为空
        node.pre = null;
        // 如果head不为空，则将head的前驱指针指向node
        if (head != null) {
            head.pre = node;
        }
        // 同时交换head和node
        head = node;
        // 若是此时的tail节点为空，则将node设值为tail
        if (tail == null) {
            tail = node;
        }
    }

    /**
     * get(key)操作的实现比较简单，直接通过判断Map是否含有key值即可，如果查找到key，则返回对应的value，否则返回-1;
     *
     * @param key
     * @return
     */
    int get(int key) {
        // 遍历map，找到key对应的node，找不到就返回-1
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Node v = entry.getValue();
            if (k.equals(key)) {
                return v.value;
            }
        }
        return -1;
    }

    /**
     * set(key, value)操作需要分情况判断。
     * 如果当前的key值对应的节点已经存在，则将这个节点取出来，并且删除节点所处的原有的位置，并在头部插入该节点；
     * 如果节点不存在节点中，这个时候需要在链表的头部插入新节点，插入新节点可能导致容量溢出，如果出现溢出的情况，则需要删除链表尾部的节点。
     *
     * @param key
     * @param value
     * @return
     */
    void set(int key, int value) {
        // 在map中找到了
        // 遍历map，找到key对应的node，找不到就返回-1
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Node v = entry.getValue();
            if (k.equals(key)) {
                // 先删除它
                remove(v);
                // 在添加到头部
                insertHead(v);
            }
        }
        // 在map中没有找到，新建一个node
        Node node = new Node(key, value);
        // 判断此时的容量是否已经达到上限，若是达到，则从末尾删除一个，然后在在头部插入node
        if (size == map.size()) {
            Node del = map.get(tail.key);
            remove(del);
            map.remove(tail.key);
        }
        // 出入到头中
        insertHead(node);
        // 添加到map中
        map.put(key, node);
    }
}
