package com.consumer;

import com.consumer.feign.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author baozc
 * @date 2019/3/13 3:06 PM
 */
@EnableFeignClients(basePackages = "com.consumer.**")
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ZkConsumerApplication {

    public static Logger logger = LoggerFactory.getLogger(ZkConsumerApplication.class);

    public static void main(String[] args){
        SpringApplication.run(ZkConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("getHello")
    public String getHello(){
        return restTemplate.getForEntity("http://server/hello", String.class).getBody();
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("getHelloEx")
    public String getHelloEx(){
        ServiceInstance instance = this.loadBalancerClient.choose("server");
        logger.info("instance host: {}, port:{}", instance.getHost(), instance.getPort());
        URI helloUri = URI.create(String.format("http://%s:%s/hello", instance.getHost(), instance.getPort()));
        logger.info("Target service uri = {}. ", helloUri.toString());
        return new RestTemplate().getForEntity(helloUri, String.class).getBody();
    }

    @Autowired
    private HelloService helloService;

    @GetMapping("getHelloFeign")
    public String helloFeign(){
        return helloService.hello();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("getHelloDiscovery")
    public String helloDiscovery(){
        String helloUri = serviceUrl1();
        logger.info("server uri: {}", helloUri);
        return new RestTemplate().getForEntity(helloUri+"/hello", String.class).getBody();
    }

    public String serviceUrl1() {
        List<ServiceInstance> list = discoveryClient.getInstances("server");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
}
