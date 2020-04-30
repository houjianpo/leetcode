package com.lc.algorithms.lc144;

import com.lc.algorithms.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * @author: 松针
 * @create: 2020-04-30 10:20
 **/
public class BinaryTreePreorderTraversal {

    /**
     * 保存遍历后的元素
     */
    private List arrayList;

    /**
     * 构造方法，初始化arrayList
     */
    public BinaryTreePreorderTraversal() {
        arrayList = new ArrayList();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode cRight = new TreeNode(2);
        root.right = cRight;
        TreeNode cRight_cLeft = new TreeNode(3);
        cRight.left = cRight_cLeft;
        List list = new BinaryTreePreorderTraversal().preorderTraversal(root);
        list.forEach(tmp -> {
            System.out.print(tmp + " ");
        });
    }

    /**
     * 先序遍历 根->左->右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 若是root为空，则直接返回
        if (null == root) {
            return arrayList;
        }
        // 若是root不为空，则加入到arrayList中
        if (null != root) {
            arrayList.add(root.val);
        }
        // 左节点不为空，继续遍历左子树
        if (null != root.left) {
            preorderTraversal(root.left);
        }
        // 右节点不为空，继续遍历右子树
        if (null != root.right) {
            preorderTraversal(root.right);
        }
        return arrayList;
    }
}
