package com.makun.design.pattern.decorate;

/**
 * 列表框类：具体构件类
 * @author Created by makun
 * @Date 2019-11-07
 */
class ListBox extends Component {

    @Override
    public void display() {
        System.out.println("显示列表框！");
    }

}
