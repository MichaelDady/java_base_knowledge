package com.makun.design.pattern.compose;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class ImageFile extends AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
        System.out.println("Sorry, method not supported ...");
    }

    @Override
    public void remove(AbstractFile file) {
        System.out.println("Sorry, method not supported ...");

    }

    @Override
    public AbstractFile getChild(int i) {
        System.out.println("Sorry, method not supported ...");

        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("We are killing virus from " + name + " in image way");
    }
}
