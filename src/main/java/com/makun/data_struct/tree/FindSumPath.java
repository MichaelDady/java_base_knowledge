package com.makun.data_struct.tree;

import java.util.Stack;

/**
 * @author Created by makun
 * @Date 2019/8/14
 */
public class FindSumPath {
    static Stack<Integer> stack = new Stack();
    private static Integer sum = 22;

    public static void main(String ss[]) {
        TreeNode root = buildData();
        findPath(root, 0);
    }

    private static void findPath(TreeNode root, Integer currentVal) {
        if (root.left == null && root.right == null) {
            if (currentVal + root.val == sum) {
                stack.add(root.val);
                print();
                stack.pop();
            }
            return;
        }
        if (root.left != null) {
            stack.add(root.val);
            findPath(root.left, currentVal + root.val);
            stack.pop();
        }
        if (root.right != null) {
            stack.add(root.val);
            findPath(root.right, currentVal + root.val);
            stack.pop();
        }

    }

    private static void print() {
        for (Integer i : stack) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static TreeNode buildData() {
        TreeNode j = new TreeNode(1);
        TreeNode i = new TreeNode(5);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode d = new TreeNode(11, g, h);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4, i, j);
        TreeNode b = new TreeNode(4, d, null);
        TreeNode c = new TreeNode(8, e, f);
        TreeNode a = new TreeNode(5, b, c);
        return a;
    }
}
