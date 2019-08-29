package com.makun.io;

import java.io.*;
import java.util.*;

/**
 * @author Created by makun
 * @Date 2019/2/25
 */
public class WriteFileUtil {
    public static void main(String[] pp) throws Exception {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/makun/Desktop/abc.txt")));
        List<Long> data = new ArrayList<>();
        data.add(100L);
        data.add(200L);
        data.add(300L);
        data.forEach(str -> {
            try {
                br.write(str + "");
                br.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        br.flush();
        br.close();
    }
}
