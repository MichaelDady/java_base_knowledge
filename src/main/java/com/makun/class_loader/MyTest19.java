package com.makun.class_loader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author kun.ma on 2019/8/29
 */
public class MyTest19 {
    public static void main(String[] args) {
        // 修改系统属性 java -Djava.ext.dirs =./ com.makun.class_loader.MyTest19 : 把值改成当前目录条件下运行这个文件
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
