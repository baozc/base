package cn.baozcc.me.common;

import cn.baozcc.me.configuration.constant.Constants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author baozc
 * @date 2019/8/7 4:43 PM
 */
@Component
public class OutputConfigRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------defaultDistance = " + Constants.defaultDistance);
        System.out.println("-----------configuration = " + Constants.s());
    }
}
