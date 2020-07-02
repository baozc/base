package cn.baozcc.mall.config;

import cn.baozcc.mall.entity.A;
import cn.baozcc.mall.entity.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @import 相当于spring配置文件中的<import>标签，
 *      用来组合多个配置类，在引入其它配置时，可以不用再写@configuration注解，当然写上也没问题。
 *      1. 可以直接引入一个类
 *      2. 可以引入一个configuration配置类
 * @author baozc
 * @date 2019/11/3 5:42 PM
 */
@Import({B.class, CConfig.class})
@Configuration
public class MallConfig {

    @Bean
    public A a(){
        return new A();
    }
}
