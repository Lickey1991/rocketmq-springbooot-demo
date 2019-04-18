package com.lickey.mq.demo;

import com.lickey.starter.rocketmq.annotation.EnableMQConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @Description:    启动类
 * @Author:         xiehuading
 * @CreateDate:     2018/11/22 下午7:24
 */
@SpringBootApplication
@EnableMQConfiguration
@Slf4j
public class Application {
	public static void main(String[] args) {
        // 程序启动入口
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        log.info("Start success......");
    }
}
