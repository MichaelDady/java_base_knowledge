package com.makun.data_struct.tree;

import java.util.Stack;

/**
 * @author Created by makun
 * @Date 2019/8/14
 */
public class FindDestNodePath {

    static Stack<Integer> stack = new Stack();
    static TreeNode j = new TreeNode(1);
    static TreeNode i = new TreeNode(5);
    static TreeNode g = new TreeNode(7);
    static TreeNode h = new TreeNode(2);
    static TreeNode d = new TreeNode(11, g, h);
    static TreeNode e = new TreeNode(13);
    static TreeNode f = new TreeNode(4, i, j);
    static TreeNode b = new TreeNode(4, d, null);
    static TreeNode c = new TreeNode(8, e, f);
    static TreeNode a = new TreeNode(5, b, c);
    static TreeNode destNode = e;
    public static void main(String[] args) {
        boolean finish = false;
        findDestNode(a,finish);
    }

    private static void findDestNode(TreeNode root, boolean finish) {
        if (root == destNode || finish) {
            return;
        }
    }

}
