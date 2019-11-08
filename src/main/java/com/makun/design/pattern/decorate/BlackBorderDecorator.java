package com.makun.design.pattern.decorate;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("为构件添加黑色边框");
    }
}
