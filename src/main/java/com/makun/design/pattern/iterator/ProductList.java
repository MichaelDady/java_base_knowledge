package com.makun.design.pattern.iterator;


import java.util.List;

/**
 * @author Created by makun
 * @Date 2019-11-08
 */
class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }

    // 实现创建迭代器对象的具体工厂方法
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
