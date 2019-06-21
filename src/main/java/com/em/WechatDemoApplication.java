package com.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hongyi Zheng
 * @date 2019-06-21
 */
@SpringBootApplication
public class WechatDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WechatDemoApplication.class);
        app.run(args);
    }
}
