package com.makun.data_struct.skip_list;

import lombok.Data;

@Data
public class SkipListNode {
    /**
     * 数值
     */
    private int data;

    /**
     * 下一个指向
     */
    private SkipListNode nextNode;

    /**
     * 指向下层的指针
     */
    private SkipListNode nextLevelNode;
}
