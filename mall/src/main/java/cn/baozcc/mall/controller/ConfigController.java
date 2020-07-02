package cn.baozcc.mall.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozc
 * @date 2019/11/3 2:59 PM
 */
@RestController
@RequestMapping("cfg")
public class ConfigController {

    @Value("${hello}")
    private String hello;

    @GetMapping("hello")
    public String hello(){
        return hello;
    }
}
