package com.test.leecode;

import java.util.*;

/**
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
 */
public class Leecode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return addNode(root, res);
    }

    /**
     * 递归
     * @param root
     * @param res
     * @return
     */
    public List<Integer> addNode(TreeNode root, List<Integer> res){
        if (root == null) {
            return res;
        }

        res.add(root.val);
        addNode(root.left, res);
        addNode(root.right, res);

        return res;
    }

    /**
     * 迭代
     * @param root
     * @param res
     * @return
     */
    public List<Integer> addNode2(TreeNode root, List<Integer> res){
        if (root == null) {
            return res;
        }

        // 使用栈去存储节点
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root.left != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return res;
    }
}
