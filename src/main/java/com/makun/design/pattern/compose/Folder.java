package com.makun.design.pattern.compose;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class Folder extends AbstractFile {
    private String name;

    private List<AbstractFile> fileList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }



    @Override
    public void add(AbstractFile file) {
        fileList.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        fileList.remove(file);

    }

    @Override
    public AbstractFile getChild(int i) {
        return fileList.remove(i);
    }

    @Override
    public void killVirus() {
        System.out.println("Killing virus from " + name + " in folder way");
        for (AbstractFile abstractFile : fileList) {
            abstractFile.killVirus();
        }
    }
}
