package com.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozc
 * @date 2019/3/13 1:46 PM
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ZkServerApplication {

    private static Logger logger = LoggerFactory.getLogger(ZkServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZkServerApplication.class, args);
        logger.info("-------------------------------------");
        for (String s : args) {
            logger.info("argument is {}", s);
        }
    }

    @GetMapping("hello")
    public String hello(){
        logger.info("***************");
        return "hello world!";
    }
}
