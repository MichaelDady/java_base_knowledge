package com.makun.design.pattern.observer;

/**
 * @author Created by makun
 * @Date 2019-11-08
 */
interface Observer {
    String getName();

    void setName(String name);

    void help(); // 声明支援盟友方法

    void beAttacked(AllyControlCenter acc); // 声明遭受攻击方法
}
