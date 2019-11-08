package com.makun.design.pattern.decorate;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class Client {
    public static void main(String[] args) {
        Component component, toBeDecorate, toBeDecorate1 ;
        component = new Window();
        toBeDecorate = new BlackBorderDecorator(component);
        toBeDecorate1 = new ScrollBarDecorator(toBeDecorate);
        toBeDecorate1.display();
    }

    /**
     * 演示为窗体添加滚动条的装饰模式
     */
    private static void addDecorator() {
        // 使用抽象构件定义
        Component component, componentDecorator;
        // 定义具体构件
        component = new Window();
        // 定义装饰后的构件
        componentDecorator = new ScrollBarDecorator(component);
        componentDecorator.display();
    }
}
