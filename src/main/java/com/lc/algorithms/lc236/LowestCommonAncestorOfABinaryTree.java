package com.lc.algorithms.lc236;

import com.lc.algorithms.base.TreeNode;

/**
 * @description: 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * @author: 松针
 * @create: 2020-04-27 14:15
 **/
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        // 初始化构造测试tree
        TreeNode root = init();
        // p节点
        TreeNode p = new TreeNode(5);
        // q节点
        TreeNode q = new TreeNode(1);
        // 查找共同的祖先
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    /**
     * 构造测试二叉树
     *                      3
     *                  5        1
     *               6    2    0    8
     *                  7   4
     *
     * @return
     */
    private static TreeNode init() {
        TreeNode root = new TreeNode(3);
        TreeNode l5 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);
        root.left = l5;
        root.right = r1;

        TreeNode l6 = new TreeNode(6);
        TreeNode r2 = new TreeNode(2);
        l5.left = l6;
        l6.right = r2;

        l6.left = null;
        l6.right = null;

        TreeNode l7 = new TreeNode(7);
        TreeNode r4 = new TreeNode(4);
        r2.left = l7;
        r2.right = r4;

        TreeNode l0 = new TreeNode(0);
        TreeNode r8 = new TreeNode(8);
        r1.left = l0;
        r1.right = r8;

        return root;
    }

    /**
     * 查找p和q共同的祖先
     *
     * @param root 二叉树的根
     * @param p    p节点
     * @param q    q节点
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return null == left ? right : null == right ? left : root;
    }
}
