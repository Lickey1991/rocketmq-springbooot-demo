package com.lickey.mq.demo.mq.producer;

import com.lickey.starter.rocketmq.annotation.MQProducer;
import com.lickey.starter.rocketmq.base.AbstractMQProducer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : lvqi
 * @date : 2019/4/11 15:11
 * @description : TODO
 */
@Component
//@MQProducer(producerGroup = "${rocketmq.groupid.test}")
public class TestProducer extends AbstractMQProducer {

    @Getter
    @Value("${rocketmq.topic.demo2}")
    private String demoTopic;

}
