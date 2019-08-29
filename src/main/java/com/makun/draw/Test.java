package com.makun.draw;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Created by makun
 * @Date 2019/6/29
 */
public class Test {
    public static void main(String ss[]) {
        Map<String, Object> map = new HashMap();
        map.put("ss", 1000L);

        System.out.println(Long.parseLong(String.valueOf(map.get("ss"))));
    }
}
