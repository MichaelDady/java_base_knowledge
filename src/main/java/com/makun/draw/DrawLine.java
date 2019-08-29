package com.makun.draw;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Created by makun
 */
public class DrawLine {
    public static void main(String[] args) {
        System.out.println((long)Math.ceil(((double)104570) * 0.00015));
    }


    public static BigDecimal penny(BigDecimal yuan) {
        if (yuan == null)
            return null;
        return Optional.ofNullable(yuan).orElse(BigDecimal.ZERO).multiply(BigDecimal.valueOf(100));
    }

    private static String  convertToJson (String str){
        String[] brandArr = str.split(";");
        String result = "";
        result += "[";
        for(int i = 0; i< brandArr.length; i++){
            String brandArrName = brandArr[i];
            String[] arr = brandArrName.split(":");
            result += "{"+"\"name\":\"" +  arr[0] + "\"," + "\"value\":\"" + arr[1]+"\"}";
            if (i < brandArr.length- 1) {
                result+=",";
            }
        }
        result += "]";
        return result;
    }
}
