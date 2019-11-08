package com.makun.design.pattern.decorate;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
// 窗体类：具体构件类

class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }

}
