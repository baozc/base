package cn.baozcc.me.configuration.datasource;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author baozc
 * @date 2019/3/20 5:18 PM
 */
@Configuration
public class DataSourceConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * mysql数据源
     *
     * @author baozc
     * @date 2019年03月20日 17:19:37
     */
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "mysql")
    public DataSource mysqlDataSource() {
        logger.info(":::::::::init druid data source");
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
}
