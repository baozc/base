package cn.baozcc.me.configuration.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 融云配置
 * @author baozc
 * @date 2019/8/7 4:25 PM
 */
@Configuration
@ConfigurationProperties(prefix = "rong")
public class RongCloud {
    public static boolean active;
    public static String url;
    public static String appKey;
    public static String appSecret;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        RongCloud.active = active;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        RongCloud.url = url;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        RongCloud.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        RongCloud.appSecret = appSecret;
    }
}
