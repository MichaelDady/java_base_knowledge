package com.makun.classloader.same_class;

/**
 * @author Created by makun
 * @Date 2019-12-09
 */
public class Sample {
    private Sample instance;

    public void setInstance(Object obj) {
        this.instance = (Sample) obj;
    }
}
