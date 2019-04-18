package com.lickey.mq.demo.mq.producer;

import com.alibaba.fastjson.JSON;
import com.lickey.mq.demo.domain.Test;
import com.lickey.starter.rocketmq.annotation.MQTransactionProducer;
import com.lickey.starter.rocketmq.base.AbstractMQTransactionProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * @author : lvqi
 * @date : 2019/4/11 15:15
 * @description : 事物消息 producer
 */
@Component
@MQTransactionProducer(producerGroup = "${rocketmq.groupid.trans}")
@Slf4j
public class RocketMqTransactionProducer extends AbstractMQTransactionProducer {


    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        Test test = (Test) arg;
        log.info("executeLocalTransaction ,arg:{}!", JSON.toJSONString(test));

        // executeLocalTransaction
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {

        log.info("checkLocalTransaction , MessageExt:{} !", JSON.toJSONString(msg));
        // LocalTransactionState.ROLLBACK_MESSAGE
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
