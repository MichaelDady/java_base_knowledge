package com.makun.design.pattern.decorate;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    private void setScrollBar() {
        System.out.println("为构件添加滚动条");
    }
}
