package com.makun;

import lombok.Data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Created by makun
 * @Date 2019-09-25
 */
public class Test {
    public static void main(String[] args) throws Exception{
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"zhangsan"));
        list.add(new Student(1,"lisi"));
        list.add(new Student(3,"zhangsan"));
        Map<Integer, List<String>> result = list.stream().collect(Collectors.groupingBy(Student::getId)).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, m->m.getValue().stream().map(Student::getName).collect(Collectors.toList())));
        System.out.println(result);
    }

    @Data
    static class Student {
        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        Integer id;
         String name;
    }

}
