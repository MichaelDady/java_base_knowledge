package com.makun.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Created by makun
 * @Date 2019-09-30
 */
public class ListOperationPerformanceCompare {
    public static void main(String[] args) {
        int initialSize = 1000;
        // 操作多少次
        int operationTime = 100000;

        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        Random random = new Random();

        // 初始化集合
        for (int i = 0; i < initialSize; i++) {
            int randInt = random.nextInt();
            arrList.add(randInt);
            linkList.add(randInt);
        }
        int tmpSize = initialSize;
        Operation[] operationArr = new Operation[operationTime];
        for (int i = 0; i < operationTime; i++) {
            int num = random.nextInt();
            int operation = num & 1;
            tmpSize += operation == 0 ? -1 : 1;
            // 拒绝指针异常
            if (tmpSize <= 0) {
                tmpSize = 1;
                operation = 1;
            }
            int idx = random.nextInt(tmpSize);
            operationArr[i] = new Operation(operation, idx, num);
        }
        calOperationCostTime(arrList, operationArr);
        calOperationCostTime(linkList, operationArr);
    }

    static void calOperationCostTime(List<Integer> list, Operation[] operationArr) {
        int len = operationArr.length;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            switch (operationArr[i].operation) {
                case 0:
                    list.remove(operationArr[i].idx);
                    // list.remove(0);
                    break;
                case 1:
                    list.add(operationArr[i].idx, operationArr[i].num);
                    // list.add(0, operationArr[i].num);
                    break;
                default:
            }
        }
        System.out.println("在集合 ：" + list.getClass().getName() + "下随机增删" + len + "次，耗时："
                + (System.currentTimeMillis() - startTime) + "ms");
    }

    static class Operation {
        public Operation(int operation, int idx, int num) {
            this.operation = operation;
            this.idx = idx;
            this.num = num;
        }

        /**
         * 0:删除 1:添加
         */
        int operation;

        /**
         * 位置
         */
        int idx;

        /**
         * 要插入的数字（如果是插入操作）
         */
        int num;
    }
}
