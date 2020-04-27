package com.lc.algorithms.lc235;

import com.lc.algorithms.base.TreeNode;

/**
 * @description: 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * @author: 松针
 * @create: 2020-04-27 14:00
 **/
public class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        // 初始化构造测试tree
        TreeNode root = init();
        // p节点
        TreeNode p = new TreeNode(2);
        // q节点
        TreeNode q = new TreeNode(8);
        // 查找共同的祖先
        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    /**
     * 构造测试二叉树
     *                      6
     *                  2        8
     *               0    4    7    9
     *                  3   5
     *
     * @return
     */
    private static TreeNode init() {
        TreeNode root = new TreeNode(6);
        TreeNode l2 = new TreeNode(2);
        TreeNode r8 = new TreeNode(8);
        root.left = l2;
        root.right = r8;

        TreeNode l0 = new TreeNode(0);
        TreeNode r4 = new TreeNode(4);
        l2.left = l0;
        l2.right = r4;

        TreeNode l3 = new TreeNode(3);
        TreeNode r5 = new TreeNode(5);
        r4.left = l3;
        r4.right = r5;

        TreeNode l7 = new TreeNode(7);
        TreeNode r9 = new TreeNode(9);
        r8.left = l7;
        r8.right = r9;

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
        if (root.val > p.val && root.val > q.val) {
            // 若是p和q都小于root，则在左子树里查找
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            // 若是p和q都大于root，则在右子树里查找
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // 当前root就是p和q的祖先
            return root;
        }
    }
}
