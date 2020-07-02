package cn.baozcc.mall.controller;

import java.util.HashMap;
import java.util.Map;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author baozc
 * @date 2019/3/4 4:18 PM
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Value("${server.port}")
    private int serverPort;

    @Value("${eureka.instance.hostname}")
    private String url;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello(){
        logger.info("url is {}", url);
        this.logger.info("/hello, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
        return "Hello, Spring Cloud! I'm mall, port is " + String.valueOf(serverPort);
    }

    @Autowired
    private EurekaClient discoveryClient;

    /**
     * 调用consumer的getMallUrl，来获取自身的访问路径
     * @return
     * @author baozc
     * @date 2019年10月30日 22:51:46
     */
    @GetMapping("consumerUrl")
    public String consumerUrl() {
        logger.info("request consumer url");
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("CONSUMER", false);
        logger.info("consumer home page url is : {}", instance.getHomePageUrl());

        Map<String, Object> map = new HashMap<>();
        map.put("type", "eureka");
        return restTemplate.getForEntity(instance.getHomePageUrl()+"/consumer/getMallUrl", String.class, map).getBody();
    }
}
