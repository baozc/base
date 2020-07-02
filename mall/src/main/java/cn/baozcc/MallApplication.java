package cn.baozcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author baozc
 * @date 2019/3/4 3:49 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class MallApplication {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(MallApplication.class, args);
    }
}
