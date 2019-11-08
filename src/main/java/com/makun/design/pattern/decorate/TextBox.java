package com.makun.design.pattern.decorate;

/**
 * @author Created by makun
 * @Date 2019-11-07
 */
// 文本框类：具体构件类

class TextBox extends Component {

    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
