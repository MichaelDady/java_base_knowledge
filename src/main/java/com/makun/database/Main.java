package com.makun.database;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Created by makun
 * @Date 2018/9/19
 */
public class Main {
    public static void main(String[] pp) {
        BplusTree tree = new BplusTree();
        FillDataUtil.fillData(tree);
//        tree.addCodeIndex();
//        List<Student> likeCodeList = tree.listByLikeCode("30");
//        List<Student> codeList = tree.listByCode("30");
//        System.out.println("12".substring(1,2));
//        System.out.println("11A".compareTo("11b"));
        differentTypeDemo();
    }


    /**
     * 示例不同的数据类型比较方式是不同的
     */
    private static void differentTypeDemo() {
        // String类型
        Map<String, String> strMap = new TreeMap<>();
        strMap.put("900", "1");
        strMap.put("3000", "2");
        strMap.put("50000", "3");
        strMap.put("100000", "4");
        System.out.println("通过String类型排序后的输出为：");
        strMap.keySet().forEach(key -> System.out.println(strMap.get(key)));

        // Integer类型
        Map<Integer, String> intMap = new TreeMap<>();
        intMap.put(900, "1");
        intMap.put(3000, "2");
        intMap.put(50000, "3");
        intMap.put(100000, "4");
        System.out.println("通过Integer类型排序后的输出为：");
        intMap.keySet().forEach(key -> System.out.println(intMap.get(key)));
    }
}
