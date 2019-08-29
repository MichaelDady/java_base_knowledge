package com.makun.data_struct.tree;

/**
 * @author Created by makun
 * @Date 2019/8/14
 */
public class TreeNode {
    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 树节点的值
     */
    Integer val;


    /**
     * 左节点
     */
    TreeNode left;

    /**
     * 右节点
     */
    TreeNode right;
}
