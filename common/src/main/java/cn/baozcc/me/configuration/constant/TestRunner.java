package cn.baozcc.me.configuration.constant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author baozc
 * @date 2019/8/7 4:43 PM
 */
@Component
public class TestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------RongCloud.url = " + RongCloud.url);
    }
}
