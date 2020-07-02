package cn.baozcc.wx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozc
 * @date 2019/10/29 5:28 PM
 */
@Slf4j
@RestController
@SpringBootApplication
public class WxApplication {
    public static void main(String[] args){
        SpringApplication.run(WxApplication.class, args);
    }

    private String token = "baozc";

    @GetMapping("test")
    public String test(){
        return "hello1";
    }

    @GetMapping("wxValidation")
    public String wxValidation(String signature, String timestamp, String nonce, String echostr){

        List<String> list = new ArrayList<>();
        list.add(timestamp);
        list.add(nonce);
        list.add(token);

        Collections.sort(list);

        StringBuilder sha1 = new StringBuilder();
        list.forEach(sha1::append);

        log.info("sha1: {}", sha1);

        String hascode = DigestUtils.sha1Hex(sha1.toString());
        log.info("hascode : {}", hascode);

        if (signature.equals(hascode)) {
            return echostr;
        }
        return null;
    }
}
