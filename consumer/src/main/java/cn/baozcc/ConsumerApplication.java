package cn.baozcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author baozc
 * @date 2019/3/4 4:23 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    RestTemplate restTemplate1() {
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
