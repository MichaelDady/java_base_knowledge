package com.makun.database;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Created by makun
 * @Date 2018/9/19
 * 类似于 create table student (id bigint primary key auto_increment, name varchar(300), score int, code varchar(200));
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student> {

    /**
     * 主键
     */
    Long id;

    /**
     * 姓名
     */
    String name;

    /**
     * 得分
     */
    Integer score;

    /**
     * 编码
     */
    String code;

    @Override
    public int compareTo(Student dest) {
        return this.id.compareTo(dest.id);
    }
}
