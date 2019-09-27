package com.makun;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Created by makun
 * @Date 2019-09-25
 */
public class Test {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dayDate = simpleDateFormat.parse("2019-09-09 12:00:01");
        System.out.println(dayDate.getTime());
    }

}
