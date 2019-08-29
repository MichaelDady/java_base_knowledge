package com.makun.database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Created by makun
 * @Date 2019/1/17
 */
class FillDataUtil {
    static void fillData(BplusTree tree) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/makun/IdeaProjects/algorithm/src/main/java/com/makun/database/data.txt")))) {
            String aline;
            while ((aline = br.readLine()) != null) {
                String[] split = aline.split(",");
                Student student = new Student(Long.parseLong(split[0].trim()), split[1].trim(), Integer.parseInt(split[2].trim()), split[3].trim());
                tree.save(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
