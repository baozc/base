package cn.baozcc.mall.config;

import cn.baozcc.mall.entity.C;
import org.springframework.context.annotation.Bean;

/**
 * @author baozc
 * @date 2019/11/3 5:47 PM
 */
public class CConfig {

    @Bean
    public C c(){
        return new C();
    }

}
