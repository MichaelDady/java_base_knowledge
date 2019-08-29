package com.makun;

import java.util.Arrays;

/**
 * @author Created by makun
 * @Date 2019/4/1
 */
public class leetcode85 {
    public static int maximalRectangleDP(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int ROW = matrix.length;
        int COL = matrix[0].length;
        int[] left = new int[COL];
        int[] right = new int[COL];
        int[] height = new int[COL];
        /**
         * 初始化
         */
        Arrays.fill(left, 0);
        Arrays.fill(right, COL);
        Arrays.fill(height, 0);

        int max = 0;//最大面积

        /**
         * 对每一行进行计算, 递推公式如下:
         * 每一行开始时,左边界定为0, 右边界定为COL
         * height[j]好算:
         *    如果matrix[i][j] = 0, height[j]不变
         *    如果matrix[i][j] = 1, height[j]++;
         * left[j]从左往右算:
         *    如果matrix[i][j] = 0, left[j]=0, 同时左边界变为当前j+1(因为潜在的左边界可能就在j+1)
         *    如果matrix[i][j] = 1, left[j]= max(left[j], 左边界), 哪个大取哪个.
         *    (解释: 因为我们要的是过往所有行中0到该列位置最晚遇到1的位置)
         * right[j]从右往左算:
         *    如果matrix[i][j] = 0, right[j]=0, 同时右边界变为当前j(因为潜在的右边界就在当前j位置)
         *    如果matrix[i][j] = 1, right[j]= min(right[j], 右边界), 哪个小取哪个.
         *    (解释: 因为我们要的是过往所有行中COL-1到该列位置最早遇到0的位置)
         */
        for (int i = 0; i < ROW; i++) {
            int leftBound = 0;
            int rightBound = COL;//如果本行全为1, 那么从右往左第一个0应该在COL处, 这是个想象的位置, 只是为方便计算.
            /**
             * 算高度
             */
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            /**
             * 算左边界
             */
            for (int j = 0; j < COL; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], leftBound);
                } else {
                    left[j] = 0;
                    leftBound = j + 1;
                }
            }

            /**
             * 算右边界
             */
            for (int j = COL - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], rightBound);
                } else {
                    rightBound = j;//当前行j到COL-1位置, 最早遇到0的位置可能就是当前
                }
            }

            /**
             * 实时计算走到当前行的最大矩形面积
             *
             */
            for (int j = 0; j < COL; j++) {
                max = Math.max((right[j] - left[j]) * height[j], max);
            }
        }
        return max;
    }

}
