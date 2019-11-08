package com.makun.design.pattern.compose;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public abstract class AbstractFile {
    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();

}
