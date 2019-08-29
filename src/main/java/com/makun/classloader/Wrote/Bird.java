package com.makun.classloader.Wrote;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author Created by makun
 * @Date 2019/8/29
 */
public class Bird {
    static AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

    private Bird bird;

    public void setBird(Object object) {
        bird = (Bird) object;
    }

}
