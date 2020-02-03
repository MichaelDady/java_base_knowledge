package com.makun.byte_demo;

import java.io.File;

public class Test {
    public static void main(String[] args)throws  Exception {
        delByPath("/Users/makun/Downloads/互联网Java工程师面试突击训练");
    }

    private static void delByPath(String path) {
        File file = new File(path);
        File[] fileList = file.listFiles();
        for (File fileItem : fileList) {
            if (fileItem.isDirectory()) {
                delByPath(fileItem.getPath());
            } else if (fileItem.getPath().endsWith(".avi")) {
                fileItem.delete();
            }
        }
    }
}
