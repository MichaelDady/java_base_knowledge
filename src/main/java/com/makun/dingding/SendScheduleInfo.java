package com.makun.dingding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCalendarCreateRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiCalendarCreateResponse;
import com.dingtalk.api.response.OapiGettokenResponse;

import java.util.Arrays;

/**
 * @author Created by makun
 * @Date 2019-10-29
 */
public class SendScheduleInfo {

    public static void main(String[] args) throws Exception {
        // https://ding-doc.dingtalk.com/doc#/serverapi2/iqel76
        String accessToken = getAccessToken();
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/calendar/create");
        OapiCalendarCreateRequest request = new OapiCalendarCreateRequest();
        OapiCalendarCreateRequest.OpenCalendarCreateVo creatVo = new OapiCalendarCreateRequest.OpenCalendarCreateVo();
        creatVo.setUuid("123456");
        creatVo.setBizId("test123");
        creatVo.setCreatorUserid("1226682231742708");
        creatVo.setSummary("测试日历创建");
        creatVo.setReceiverUserids(Arrays.asList("01376814877479"));
        OapiCalendarCreateRequest.DatetimeVo start = new OapiCalendarCreateRequest.DatetimeVo();
        start.setUnixTimestamp(System.currentTimeMillis()-10000);
        creatVo.setStartTime(start);
        OapiCalendarCreateRequest.DatetimeVo end = new OapiCalendarCreateRequest.DatetimeVo();
        end.setUnixTimestamp(System.currentTimeMillis());
        creatVo.setEndTime(end);
        creatVo.setCalendarType("notification");
        OapiCalendarCreateRequest.OpenCalendarSourceVo source = new OapiCalendarCreateRequest.OpenCalendarSourceVo();
        source.setTitle("招聘");
        source.setUrl("http://www.dingtalk.com/page=xxx");
        creatVo.setSource(source);
        request.setCreateVo(creatVo);
        OapiCalendarCreateResponse response = client.execute(request, accessToken);
        System.out.println(response);
    }

    private static String getAccessToken()  throws Exception{
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingslknk71rbtrrz66u");
        request.setAppsecret("eZHhZtU8zRLtkzHNjdOyRkLyeG6WotYDGVQc9rZh6r_zwFiuV_X0NvbkAAY5mKUd");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        System.out.println(response);
        System.out.println(response.getAccessToken());
        return response.getAccessToken();
    }
}
