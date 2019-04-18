package com.lickey.demo;

import com.lickey.mq.demo.Application;
import com.lickey.mq.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : lvqi
 * @date : 2019/4/11 16:19
 * @description : 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@MapperScan(basePackages = {"com.lickey.mq.demo.dao"})
@Slf4j
public class TestServiceTest {
    @Autowired
    private TestService testService;
    @Test
    public void sendMessage() {
        testService.sendMqMessage(1);
    }

    @Test
    public void asyncSend() {
        testService.asyncSend();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendTransactionMessage() {
        testService.transactionSend();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
