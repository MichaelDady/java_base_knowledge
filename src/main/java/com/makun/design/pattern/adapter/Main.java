package com.makun.design.pattern.adapter;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class Main {
    public static void main(String[] args) {
        // 针对抽象目标接口编程
        ScoreOperation operation;
        // 读取配置文件，反射生成对象
        operation = (ScoreOperation) XMLUtil.getBean();
        // 定义成绩数组
        int[] scores = {84, 76, 50, 69, 90, 91, 88, 96};
        int[] result;
        int score;

        System.out.println("成绩排序结果：");
        assert operation != null;
        result = operation.sort(scores);

        // 遍历输出成绩
        for (int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();

        System.out.println("查找成绩90：");
        score = operation.search(result, 90);
        if (score != -1) {
            System.out.println("找到成绩90。");
        } else {
            System.out.println("没有找到成绩90。");
        }

        System.out.println("查找成绩92：");
        score = operation.search(result, 92);
        if (score != -1) {
            System.out.println("找到成绩92。");
        } else {
            System.out.println("没有找到成绩92。");
        }
    }
}
