package cn.baozcc.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author baozc
 * @date 2019/3/4 4:27 PM
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getMallHello", method = RequestMethod.GET)
    public String getHello() {
        logger.info("consumer request");
        return restTemplate.getForEntity("http://mall/hello", String.class).getBody();
    }

    @Autowired
    @Qualifier("restTemplate1")
    private RestTemplate restTemplate1;

    @GetMapping("apps")
    @ResponseBody
    public String apps(){
        return restTemplate1.getForObject("http://localhost:8080/eureka/apps/consumer", String.class);
    }

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private DiscoveryClient discoveryClient1;

    /**
     * 获取mall的访问地址
     * @param type eureka客户端类型
     * @return url
     * @author baozc
     * @date 2019年10月30日 22:51:10
     */
    @GetMapping("getMallUrl")
    public String getMallUrl(String type) {
        if (type.equals("eureka")) {
            InstanceInfo instance = discoveryClient.getNextServerFromEureka("mall", false);
            return "use eurekaClient get mall url: " + instance.getHomePageUrl();
        } else if (type.equals("discovery")) {
            List<ServiceInstance> list = discoveryClient1.getInstances("mall");
            if (list != null && list.size() > 0 ) {
                return "use discoveryClient get mall url: " + list.get(0).getUri().toString();
            }
        }
        return null;
    }

}
