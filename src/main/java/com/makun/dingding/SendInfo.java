package com.makun.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.taobao.api.ApiException;

/**
 * @author Created by makun
 * @Date 2019-10-23
 */
public class SendInfo {
    //
    public static void main(String[] args) {
        SendTextMessage.sendWithAtAll("我是测试的！！！");
    }

}
