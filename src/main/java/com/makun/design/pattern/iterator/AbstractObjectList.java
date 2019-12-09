package com.makun.design.pattern.iterator;

import java.util.*;

/**
 * @author Created by makun
 * @Date 2019-11-08
 */
abstract class AbstractObjectList {
    private List<Object> objects;

    AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    List getObjects() {
        return this.objects;
    }

    // 声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();
}
