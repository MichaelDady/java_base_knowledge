package com.makun.annotation;

import lombok.Data;

/**
 * @author Created by makun
 * @Date 2018/6/2.
 */
@Data
public class Apple {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String fruitColor;

    @FruitProvider(id = 345678,name = "杭州富士山",address = "云栖小镇")
    private String fruitProvider;

}
