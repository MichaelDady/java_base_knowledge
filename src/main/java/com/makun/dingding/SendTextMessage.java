package com.makun.dingding;

import lombok.extern.slf4j.Slf4j;
import java.util.*;

/**
 * @author Created by makun
 * @Date 2019-10-29
 */
@Slf4j
public class SendTextMessage {
    /**
     * 机器人消息token
     */
    private static String WEBHOOK_TOKEN =
            "https://oapi.dingtalk.com/robot/send?access_token=62d028b7e5a7f58b34135c9d6e97b76a4612ade47f6f4d474cb86b2394f324fa";

    private static RobotClient robot = new RobotClient();

    /**
     * 发送普通文本消息
     *
     * @param message
     * @return
     */
    public static SendResult send(String message) {
        TextMessage textMessage = new TextMessage(message);
        SendResult sendResult = null;
        try {
            sendResult = robot.send(WEBHOOK_TOKEN, textMessage);
        } catch (Exception e) {
            // log.error("===> send robot message error:", sendResult);
        }
        return sendResult;
    }

    /**
     * 发送文本消息 可以@部分人
     *
     * @param message
     * @param atMobiles 要@人的电话号码 ArrayList<String>
     * @return
     */
    public static SendResult sendWithAt(String message, ArrayList<String> atMobiles) {
        TextMessage textMessage = new TextMessage(message);
        SendResult sendResult = null;
        textMessage.setAtMobiles(atMobiles);
        try {
            sendResult = robot.send(WEBHOOK_TOKEN, textMessage);
        } catch (Exception e) {
            // log.error("===> send robot message atPeople error:", sendResult);
        }
        return sendResult;
    }

    /**
     * 发送文本消息 并@所有人
     *
     * @param message
     * @return
     */
    public static SendResult sendWithAtAll(String message) {
        TextMessage textMessage = new TextMessage(message);
        SendResult sendResult = null;
        textMessage.setIsAtAll(false);
        try {
            sendResult = robot.send(WEBHOOK_TOKEN, textMessage);
        } catch (Exception e) {
            // log.error("===> send robot message atAll error:", sendResult);
        }
        return sendResult;
    }
}
