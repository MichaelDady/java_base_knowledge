package com.makun.proxy.static_proxy;

/**
 * @author Created by makun
 * @Date 2019-09-19
 */
public class FeederProxy implements Cat {
    private Cat cat;

    public FeederProxy() {}

    public FeederProxy(Cat cat) {
        if (cat instanceof Cat) {
            this.cat = cat;
        }
    }

    public void setCat(Cat cat) {
        if (cat instanceof Cat) {
            this.cat = cat;
        }
    }

    @Override
    public String eatFood(String foodName) {
        System.out.println("proxy Lion exec eatFood ");
        return cat.eatFood(foodName);
    }

    @Override
    public boolean running() {
        System.out.println("proxy Lion exec running.");
        return cat.running();
    }
}
