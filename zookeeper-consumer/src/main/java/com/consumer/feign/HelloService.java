package com.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author baozc
 * @date 2019/3/13 7:31 PM
 */
@FeignClient("server")
public interface HelloService {

    /**
     * sss
     * @param
     * @return
     * @author baozc
     * @date 2019年03月14日 09:39:25
     */
    @RequestMapping("/hello")
    String hello();
}
