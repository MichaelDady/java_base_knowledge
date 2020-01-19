package com.makun.frame.rocketmq;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("producer1");
        producer.setNamesrvAddr("10.201.45.184:3354");
        producer.start();

        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicMessage", "TagA", ("hello, rocketmq:" + i).getBytes("utf-8"));

            SendResult sendResult = producer.send(message);
            System.out.println(sendResult.getSendStatus());
            System.out.println(sendResult);
        }

        producer.shutdown();
    }


}


