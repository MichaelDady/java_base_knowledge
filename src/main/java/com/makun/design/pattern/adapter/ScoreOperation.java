package com.makun.design.pattern.adapter;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public interface ScoreOperation {
    /**
     * 成绩排序
     */
    int[] sort(int[] array);

    /**
     * 成绩查找
     */
    int search(int[] array, int key);

}
