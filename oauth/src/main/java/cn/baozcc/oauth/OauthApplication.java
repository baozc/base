package cn.baozcc.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author baozc
 * @date 2020/6/1 9:01 PM
 */
@SpringBootApplication
public class OauthApplication {

    public static void main(String[] args){
        SpringApplication.run(OauthApplication.class);
    }
}
