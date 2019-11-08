package com.makun.design.pattern.decorate;

/**
 * 构件装饰类：抽象装饰类
 * 
 * @author Created by makun
 * @Date 2019-11-07
 */
public class ComponentDecorator extends Component {
    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
