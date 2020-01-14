package com.makun.data_struct.skip_list;

public class MySkipList {
    /**
     * 第一层间隔数
     */
    private final int LEVEL_ONE_NUM = 25;

    /**
     * 第二层间隔数
     */
    private final int LEVEL_TWO_NUM = 5;

    /**
     * 第一层索引
     */
    private SkipListNode levelOneHead;

    /**
     * 第二层索引
     */
    private SkipListNode levelTwoHead;

    /**
     * 实际数据层
     */
    private SkipListNode head;

    public MySkipList() {
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {

    }
}
